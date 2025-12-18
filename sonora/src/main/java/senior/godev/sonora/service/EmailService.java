package senior.godev.sonora.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import senior.godev.sonora.models.dtoMail.Email;
import senior.godev.sonora.models.reserva.MotivoCancelamento;
import senior.godev.sonora.models.reserva.Reserva;
import senior.godev.sonora.repository.MembroRepository;
import senior.godev.sonora.repository.ReservaRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmailService {
    private final JavaMailSender mailSender;


    @Autowired
    private ReservaRepository reservaRepository;

    private ReservaService reservaService;
    @Autowired
    private MembroRepository membroRepository;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Autowired
    public void setReservaService(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    public void send(Email email) {
        var message = new SimpleMailMessage();
        message.setFrom("noreply@email.com");
        message.setTo(email.to());
        message.setSubject(email.subject());
        message.setText(email.body());
        mailSender.send(message);
    }

    //Metodos agendados
    // Todos os dias a 5 da manhã vai conferir no banco todas as reservas, e vai mandar um email dizendo que
    // precisa confirmar a reserva do dia
    @Scheduled(cron = "0 0 5 * * *")
    public void enviarEmailDiarioAsCincoDaManha() {
        System.out.println("Iniciando o envio do e-mail agendado às 5h...");

        LocalDateTime agora = LocalDateTime.now();

        for (Reserva reserva : reservaRepository.findAllbyDataHoraInicio(agora)) {
            String corpo = String.format("""
                            Prezado(a) Membro(a),
                            
                                Lembramos que a confirmação da reserva é essencial para garantir a disponibilidade do recurso para toda a comunidade.
                            
                                Informamos que a sua reserva agendada em nosso sistema foi pre-cancelada automaticamente.
                            
                                Se desejar, você pode realizar uma nova reserva através do nosso aplicativo ou site.
                            
                                Item Reservado: %s, %s - %s
                                Data e Hora Início: %s
                            
                                Atenciosamente,
                            
                                Equipe SONORA
                            """,
                    reserva.getInstrumento().getNome() != null ? reserva.getInstrumento().getNome() : "",
                    reserva.getSala().getNome(),
                    reserva.getSala().getId().toString(),
                    reserva.getDataHoraInicio().toLocalTime().toString()
            );
            Email email = new Email(
                    reserva.getMembro().getEmail(),
                    "SONORA: Confirmação da reserva",
                    corpo
            );
            send(email);
            reservaService.preCancelamento(reserva, MotivoCancelamento.NAO_CONFIRMACAO_TEMPO);
        }

        System.out.println("E-mail diário enviado com sucesso!");
    }

    // Metodo vai conferir todas as reservas em cada 10 minutos pra avisar a perda da reserva e liberando pro proximo,
    // na tratativa vai estar liberado para o proximo confirma, sem precisar de 10 minutos.
    @Scheduled(cron = "0 0/10 * * * *")
    @Transactional
    public void checarEConfirmarReservas() {
        System.out.println("Iniciando checagem de reservas para confirmação/cancelamento...");

        LocalDateTime limiteSuperior = LocalDateTime.now().plusMinutes(10);

        List<Reserva> reservasVencendo = reservaRepository.findAllReservasPendentesVencendo(limiteSuperior);

        for (Reserva reserva : reservasVencendo) {
            if (reserva.getDataHoraInicio().isBefore(LocalDateTime.now())) {

                // Cancelamento definitivo (já passou dos 10 minutos)

                String corpo = String.format("""
                                Prezado(a) Membro(a),
                                
                                    Informamos que a sua reserva agendada em nosso sistema foi cancelada automaticamente.
                                    É importante para comunidade sempre confirmar, mas como limite de tempo de confirmação foi estrapolada foi cancelada.
                                
                                    Se desejar, você pode realizar uma nova reserva através do nosso aplicativo ou site.
                                
                                    Item Reservado: %s, %s - %s
                                    Data e Hora Início: %s
                                
                                    Atenciosamente,
                                
                                    Equipe SONORA
                                """,
                        reserva.getInstrumento().getNome() != null ? reserva.getInstrumento().getNome() : "",
                        reserva.getSala().getNome(),
                        reserva.getSala().getId().toString(),
                        reserva.getDataHoraInicio().toLocalTime().toString()
                );

                reservaService.cancelamentoFinalEPromocao(reserva, MotivoCancelamento.NAO_CONFIRMACAO_TEMPO);
                Email email = new Email(
                        reserva.getMembro().getEmail(),
                        "SONORA: Cancelamento Automatico na reserva",
                        corpo
                );
                send(email);

            }
        }
    }

    public void enviarEmailConfirmacaoPromocao(Reserva proximo) {
        String corpo = String.format("""
                        Prezado(a) Membro(a),
                        
                            Informamos que a sua reserva agendada em nosso sistema como espera de uso foi liberada.
                        
                            Lembramos que a confirmação da reserva é essencial para garantir a disponibilidade do recurso para toda a comunidade.
                            Se não vai ser utilizada Sala ou Instrumento, cancela imeditamente para o proximo for usar.  
                        
                            Se desejar, você pode realizar uma nova reserva através do nosso aplicativo ou site.
                        
                            Item Reservado: %s, %s - %s
                            Data e Hora Início: %s
                        
                            Atenciosamente,
                        
                            Equipe SONORA
                        """,
                proximo.getInstrumento().getNome() != null ? proximo.getInstrumento().getNome() : "",
                proximo.getSala().getNome(),
                proximo.getSala().getId().toString(),
                proximo.getDataHoraInicio().toLocalTime().toString()
        );

        Email email = new Email(
                proximo.getMembro().getEmail(),
                "SONORA: Confirmação e Disponibilidade da reserva",
                corpo
        );

        send(email);

    }
}

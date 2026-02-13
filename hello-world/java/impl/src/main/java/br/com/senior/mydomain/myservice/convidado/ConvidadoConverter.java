package br.com.senior.mydomain.myservice.convidado;

import br.com.senior.mydomain.myservice.ConvidadoEntity;
import br.com.senior.mydomain.myservice.UpdateConvidadoNomeByIdInput;
import br.com.senior.mydomain.myservice.UpdateConvidadoNomeByIdOutput;
import org.springframework.stereotype.Service;

@Service
public class ConvidadoConverter {

    public UpdateConvidadoNomeByIdOutput toUpdateConvidadoNomeById(ConvidadoEntity convidado) {
        final UpdateConvidadoNomeByIdOutput output = new UpdateConvidadoNomeByIdOutput();

        output.id = String.valueOf(convidado.getId());
        output.nome = convidado.getNome();

        return output;
    }
}

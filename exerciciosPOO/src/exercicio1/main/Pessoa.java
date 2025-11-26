package exercicio1.main;

import exercicio1.exception.PessoaException;
import meth.ValidaCpf;

public class Pessoa {
    private String nome;
    private String cpf;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {

        if (nome == null || nome.isEmpty()) {
            throw new PessoaException("Nome deve ser informado");
        }

        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {

        var validadorCpf = new ValidaCpf();
        // Classe para validação basica de Cpf

        if (!validadorCpf.isCpf(cpf)) {
            throw new PessoaException("Cpf invalido");
        }

        this.cpf = cpf;
    }
}

package meth;

public class ValidaCpf {
    public boolean isCpf(String cpf) {
        cpf = cpf.replaceAll("\\D", "");

        return cpf.length() == 11 && !cpf.matches("(\\d)\\1{10}");
    }

    public String imprimeCpf(String cpf) {
        cpf = cpf.replaceAll("\\D", "");

        return(cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6,9) + "-" + cpf.substring(9,11));
    }
}

package exercicios;

import java.util.HashMap;
import java.util.Map;

public class Exercicio2 {
    public String trsnformacao (int numero) {
        if (numero < 1 || numero > 3999) {
            throw new IllegalArgumentException("so pode de 1 ate 3999");
        }

        Map <String, String> numeroR = new HashMap<String, String>();
        Map <String, String> dezenasR = new HashMap<String, String>();
        Map <String, String> centenasR = new HashMap<String, String>();
        Map <String, String> milsR = new HashMap<String, String>();

        numeroR.put("0", "");
        numeroR.put("1", "I");
        numeroR.put("2", "II");
        numeroR.put("3", "III");
        numeroR.put("4", "IV");
        numeroR.put("5", "V");
        numeroR.put("6", "VI");
        numeroR.put("7", "VII");
        numeroR.put("8", "VIII");
        numeroR.put("9", "IX");

        dezenasR.put("0", "");
        dezenasR.put("1", "X");
        dezenasR.put("2", "XX");
        dezenasR.put("3", "XXX");
        dezenasR.put("4", "XL");
        dezenasR.put("5", "L");
        dezenasR.put("6", "LX");
        dezenasR.put("7", "LXX");
        dezenasR.put("8", "LXXX");
        dezenasR.put("9", "XC");

        centenasR.put("0", "");
        centenasR.put("1", "C");
        centenasR.put("2", "CC");
        centenasR.put("3", "CCC");
        centenasR.put("4", "CD");
        centenasR.put("5", "D");
        centenasR.put("6", "DC");
        centenasR.put("7", "DCC");
        centenasR.put("8", "DCCC");
        centenasR.put("9", "CM");

        milsR.put("0", "");
        milsR.put("1", "M");
        milsR.put("2", "MM");
        milsR.put("3", "MMM");

        String numeroS = String.valueOf(numero);

        String valorRomano = "";

        if (numeroS.length() == 4) {
            valorRomano = milsR.get(numeroS.substring(0,1));
            valorRomano += centenasR.get(numeroS.substring(1,2));
            valorRomano += dezenasR.get(numeroS.substring(2,3));
            valorRomano += numeroR.get(numeroS.substring(3,4));
        } else if (numeroS.length() == 3) {
            valorRomano = centenasR.get(numeroS.substring(0,1));
            valorRomano += dezenasR.get(numeroS.substring(1,2));
            valorRomano += numeroR.get(numeroS.substring(2,3));
        } else if (numeroS.length() == 2) {
            valorRomano = dezenasR.get(numeroS.substring(0,1));
            valorRomano += numeroR.get(numeroS.substring(1,2));
        } else {
            valorRomano = numeroR.get(numeroS.substring(0,1));
        }

        return valorRomano;
    }
}

package util;

import java.time.LocalDate;
import java.time.Period;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Validador {
    public static boolean validarNome(String nome) {
    return nome != null && nome.trim().length() >= 3 && nome.matches("[A-Za-zÀ-ÿ\\s]+");
    }


    public static boolean validarEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }

    public static boolean validarCpf(String cpf) {
    return cpf != null && cpf.replaceAll("[^\\d]", "").matches("\\d{11}");
    }

    public static boolean validarDataNascimento(LocalDate data) {
        if (data == null) return false;
        return Period.between(data, LocalDate.now()).getYears() >= 16;
    }

    public static boolean validarCargaHoraria(int carga) {
        return carga >= 20;
    }

    public static boolean validarLimiteAlunos(int limite) {
        return limite >= 1;
    }
}

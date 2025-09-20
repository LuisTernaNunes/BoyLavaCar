package br.com.boylavacar.BoyLavaCar.Domain.Datas.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public record DTOdata (LocalDate dia,List<HoraDisponivel> horas){
    public String diaFormatado() {
        return dia.format(DateTimeFormatter.ofPattern("EEEE dd/MM", new Locale("pt", "BR")));
    }
}

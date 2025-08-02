package br.com.boylavacar.BoyLavaCar.Datas.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public record DTOdata (LocalDate dia,List<LocalTime> horas){
    public String diaFormatado() {
        return dia.format(DateTimeFormatter.ofPattern("EEEE dd/MM"));
    }
}

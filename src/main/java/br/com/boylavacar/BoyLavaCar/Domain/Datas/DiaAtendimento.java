package br.com.boylavacar.BoyLavaCar.Domain.Datas;

import lombok.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class DiaAtendimento {
    private Long id;
    private DayOfWeek dia;
    private LocalTime abertura;
    private LocalTime fechamento;
    private Boolean status;

    public DiaAtendimento(DayOfWeek dia, String abertura, String fechamento,Boolean status) {
        this.dia = dia;
        this.abertura = LocalTime.parse(abertura);
        this.fechamento = LocalTime.parse(fechamento);
        this.status = status;
    }

    public DiaAtendimento(DayOfWeek dia, boolean status) {
        this.dia = dia;
        this.status = status;
    }
}

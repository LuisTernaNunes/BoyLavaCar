package br.com.boylavacar.BoyLavaCar.Domain.Agendamento.Service;

import br.com.boylavacar.BoyLavaCar.Domain.Agendamento.DTO.DTOFormAgenda;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Service
public class ValidaHorario {
    public LocalDateTime valida(DTOFormAgenda dados){
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");
        LocalDate data = LocalDate.parse(dados.dia());
        LocalTime hora = LocalTime.parse(dados.hora(),formatoHora);
        return LocalDateTime.of(data,hora);
    }
}

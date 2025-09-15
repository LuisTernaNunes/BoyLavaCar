package br.com.boylavacar.BoyLavaCar.Domain.Agendamento.Service;

import br.com.boylavacar.BoyLavaCar.Datas.Service.DTOdata;
import br.com.boylavacar.BoyLavaCar.Datas.Service.HoraDisponivel;
import br.com.boylavacar.BoyLavaCar.Domain.Agendamento.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AgendamentoData {
    @Autowired
    AgendamentoRepository repository;

    public DTOdata[] DiaDisponiveis() {
        DTOdata[] dias = new DTOdata[5];
        LocalDate hoje = LocalDate.now(ZoneId.of("America/Sao_Paulo"));
        LocalTime horaAtual = LocalTime.now(ZoneId.of("America/Sao_Paulo"));

        for (int i = 0; i < 5; i++) {
            LocalDate data = hoje.plusDays(i);
            List<HoraDisponivel> horas = new ArrayList<>();

            if (data.equals(hoje)) {
                int horaLimite = horaAtual.plusHours(1).getHour();
                for (int j = Math.max(horaLimite, 8); j < 17; j++) {
                    horas.add(vereficaHoraDisponivel(LocalDateTime.of(data,LocalTime.of(j, 0))));
                }
            } else {
                for (int j = 8; j < 17; j++) {
                    horas.add(vereficaHoraDisponivel(LocalDateTime.of(data,LocalTime.of(j, 0))));
                }
            }
            dias[i] = new DTOdata(data, horas);
        }

        return dias;
    }

    public HoraDisponivel vereficaHoraDisponivel(LocalDateTime hora){
        var disponibilidade = repository.existsByDataAgendamento(hora);
        return new HoraDisponivel(hora.toLocalTime(),disponibilidade);
    }
}

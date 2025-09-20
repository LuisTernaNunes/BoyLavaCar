package br.com.boylavacar.BoyLavaCar.Domain.Agendamento.Service;

import br.com.boylavacar.BoyLavaCar.Domain.Datas.DiaAtendimento;
import br.com.boylavacar.BoyLavaCar.Domain.Datas.Service.DTOdata;
import br.com.boylavacar.BoyLavaCar.Domain.Datas.Service.HoraDisponivel;
import br.com.boylavacar.BoyLavaCar.Domain.Agendamento.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class AgendamentoData {
    @Autowired
    AgendamentoRepository repository;

    public List<DTOdata> DiaDisponiveis() {
        List<DTOdata> dias = new ArrayList<>();
        LocalDate hoje = LocalDate.now(ZoneId.of("America/Sao_Paulo"));
        LocalTime horaAtual = LocalTime.now(ZoneId.of("America/Sao_Paulo"));
        int i = 0;
        while (dias.size() < 5) {
            LocalDate data = hoje.plusDays(i);
            i++;
            List<HoraDisponivel> horas = new ArrayList<>();
            var diasAtendimento = vereficaDia();

            var diaHoje = diasAtendimento.stream().filter(d -> d.getDia()
                    .equals(data.getDayOfWeek()))
                    .findFirst()
                    .orElse(null);

            if(diaHoje.getStatus()) {
                System.out.println(data.equals(hoje));
                if (data.equals(hoje)) {
                    int horaLimite = horaAtual.plusHours(1).getHour();
                    for (int j = Math.max(horaLimite, diaHoje.getAbertura().getHour()); j < diaHoje.getFechamento().getHour() - 1; j++) {
                        horas.add(vereficaHoraDisponivel(LocalDateTime.of(data, LocalTime.of(j, 0))));
                    }
                } else {
                    for (int j = diaHoje.getAbertura().getHour(); j < diaHoje.getFechamento().getHour(); j++) {
                        horas.add(vereficaHoraDisponivel(LocalDateTime.of(data, LocalTime.of(j, 0))));
                    }
                }
                dias.add(new DTOdata(data, horas));
            }
        }
        return dias;
    }

    public HoraDisponivel vereficaHoraDisponivel(LocalDateTime hora){
        var disponibilidade = repository.existsByDataAgendamento(hora);
        return new HoraDisponivel(hora.toLocalTime(),disponibilidade);
    }

    public List<DiaAtendimento> vereficaDia(){
        return criaDiaAtendimento();
    }
    //metodo temporario
    public List<DiaAtendimento> criaDiaAtendimento(){
        DiaAtendimento seg = new DiaAtendimento(DayOfWeek.MONDAY,"08:00","18:00",true);
        DiaAtendimento ter = new DiaAtendimento(DayOfWeek.TUESDAY,"08:00","18:00",true);
        DiaAtendimento qua = new DiaAtendimento(DayOfWeek.WEDNESDAY,"08:00","18:00",true);
        DiaAtendimento qui = new DiaAtendimento(DayOfWeek.THURSDAY,"08:00","18:00",true);
        DiaAtendimento sex = new DiaAtendimento(DayOfWeek.FRIDAY,"08:00","18:00",true);
        DiaAtendimento sab = new DiaAtendimento(DayOfWeek.SATURDAY,"08:00","12:00",true);
        DiaAtendimento dom = new DiaAtendimento(DayOfWeek.SUNDAY,false);
        List<DiaAtendimento> dias = new ArrayList<>();
        dias.add(seg);
        dias.add(ter);
        dias.add(qua);
        dias.add(qui);
        dias.add(sex);
        dias.add(sab);
        dias.add(dom);
        return dias;
    }
}

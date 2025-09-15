package br.com.boylavacar.BoyLavaCar.Domain.Agendamento.Service;

import br.com.boylavacar.BoyLavaCar.Domain.Agendamento.Agendamento;
import br.com.boylavacar.BoyLavaCar.Domain.Agendamento.AgendamentoRepository;
import br.com.boylavacar.BoyLavaCar.Domain.Agendamento.StatusAgendamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarregaAgendamento {

    @Autowired
    AgendamentoRepository agendamentoRepository;

    public List<Agendamento> buscaAgendamento(){
        LocalDate hoje = LocalDate.now();
        LocalDateTime inicio = hoje.atStartOfDay();
        LocalDateTime fim = hoje.atTime(LocalTime.MAX);
        return agendamentoRepository.findByStatusAndDataAgendamentoBetween(StatusAgendamento.ABERTO,inicio, fim);
    }

    public List<Agendamento> buscaAgendamentoDia(String filtro){
        LocalDateTime inicio, fim;
        switch(filtro) {
            case "Hoje":
                inicio = LocalDate.now().atStartOfDay();
                fim = LocalDate.now().atTime(LocalTime.MAX);
                break;
            case "Amanha":
                inicio = LocalDate.now().plusDays(1).atStartOfDay();
                fim = LocalDate.now().plusDays(1).atTime(LocalTime.MAX);
                break;
            case "Anteriores":
                inicio = LocalDateTime.MIN;
                fim = LocalDate.now().minusDays(1).atTime(LocalTime.MAX);
                break;
            case "Futuros":
                inicio = LocalDate.now().plusDays(2).atStartOfDay();
                fim = LocalDate.now().plusDays(9).atStartOfDay();
                System.out.println("Busca Futuros");
                break;
            default:
                inicio = LocalDate.now().atStartOfDay();
                fim = LocalDate.now().atTime(LocalTime.MAX);
        }
        return agendamentoRepository.findByStatusAndDataAgendamentoBetween(StatusAgendamento.ABERTO,inicio, fim);
    }

}

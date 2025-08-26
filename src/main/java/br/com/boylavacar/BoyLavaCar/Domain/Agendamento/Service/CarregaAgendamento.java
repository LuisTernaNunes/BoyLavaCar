package br.com.boylavacar.BoyLavaCar.Domain.Agendamento.Service;

import br.com.boylavacar.BoyLavaCar.Domain.Agendamento.Agendamento;
import br.com.boylavacar.BoyLavaCar.Domain.Agendamento.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarregaAgendamento {

    @Autowired
    AgendamentoRepository agendamentoRepository;

    public List<Agendamento> buscaAgendamento(){
        List<Agendamento> agendamentosList = agendamentoRepository.findAll();
        return agendamentosList;
    }

}

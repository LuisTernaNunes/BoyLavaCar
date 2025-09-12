package br.com.boylavacar.BoyLavaCar.Domain.Agendamento.Service;

import br.com.boylavacar.BoyLavaCar.Domain.Agendamento.Agendamento;
import br.com.boylavacar.BoyLavaCar.Domain.Agendamento.AgendamentoRepository;
import br.com.boylavacar.BoyLavaCar.Domain.Agendamento.StatusAgendamento;
import br.com.boylavacar.BoyLavaCar.Domain.Financeiro.Pagamento;
import br.com.boylavacar.BoyLavaCar.Domain.Financeiro.Repository.PagamentoRepository;
import br.com.boylavacar.BoyLavaCar.Domain.Financeiro.StatusPagamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FinalizarAgendamento {
    @Autowired
    AgendamentoRepository agendamentoRepository;

    public void finalizar(Long idAgendamento){
        Optional<Agendamento> agendamentoOptional = agendamentoRepository.findById(idAgendamento);
        if (agendamentoOptional.isPresent()){
            var agendamento = agendamentoOptional.get();
            agendamento.setStatus(StatusAgendamento.FINALIZADO);
            for(Pagamento p : agendamento.getPagamentos()){
                p.setStatus(StatusPagamento.CONCLUIDO);
            }
            agendamentoRepository.save(agendamento);
        }
    }
}

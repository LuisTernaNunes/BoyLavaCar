package br.com.boylavacar.BoyLavaCar.Domain.Financeiro.Service;

import br.com.boylavacar.BoyLavaCar.Domain.Agendamento.AgendamentoRepository;
import br.com.boylavacar.BoyLavaCar.Domain.Financeiro.DTOFormPagamento;
import br.com.boylavacar.BoyLavaCar.Domain.Financeiro.Pagamento;
import br.com.boylavacar.BoyLavaCar.Domain.Financeiro.Repository.CaixaRepository;
import br.com.boylavacar.BoyLavaCar.Domain.Financeiro.Repository.PagamentoRepository;
import br.com.boylavacar.BoyLavaCar.Domain.Financeiro.StatusCaixa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalvaPagamento {
    @Autowired
    CaixaRepository caixaRepository;

    @Autowired
    AgendamentoRepository agendamentoRepository;

    @Autowired
    PagamentoRepository pagamentoRepository;

    public void gravaPagamento(DTOFormPagamento dados){
        var caixaOptional = caixaRepository.findByStatus(StatusCaixa.ABERTO);
        if(caixaOptional.isPresent()){
            var caixa = caixaOptional.get();
            caixa.adicionaPagamentoCaixa(dados.valorPagamento());
            var agendamentoOptional = agendamentoRepository.findById(dados.idAgendamento());
            if(agendamentoOptional.isPresent()){
                var agendamento = agendamentoOptional.get();
                Pagamento pagamento = new Pagamento(dados,caixa,agendamento);
                pagamentoRepository.save(pagamento);
            }else {
                System.out.println("erro de agendamento");
            }
        }else{
            System.out.println("erro de caixa");
        }
    }
}

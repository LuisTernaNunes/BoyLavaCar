package br.com.boylavacar.BoyLavaCar.Domain.Financeiro.Service;

import br.com.boylavacar.BoyLavaCar.Domain.Financeiro.DTOPagamento;
import br.com.boylavacar.BoyLavaCar.Domain.Financeiro.Pagamento;
import br.com.boylavacar.BoyLavaCar.Domain.Financeiro.Repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class BuscaPagamento {
    @Autowired
    PagamentoRepository pagamentoRepository;


    public List<DTOPagamento> busca(Long id){
        List<Pagamento> pagamentos = pagamentoRepository.findAllByAgendamento_Id(id);
        List<DTOPagamento> dtos = pagamentos.stream()
                .map(p -> new DTOPagamento(p.getId(), p.getAgendamento().getId(),p.getForma(),p.getValor()))
                .collect(Collectors.toList());
        return dtos;
    }
}

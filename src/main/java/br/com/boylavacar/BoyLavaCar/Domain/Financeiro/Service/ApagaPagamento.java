package br.com.boylavacar.BoyLavaCar.Domain.Financeiro.Service;

import br.com.boylavacar.BoyLavaCar.Domain.Financeiro.Repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApagaPagamento {
    @Autowired
    PagamentoRepository pagamentoRepository;
    public void apagar(Long idPagamento){
        pagamentoRepository.deleteById(idPagamento);
    }
}

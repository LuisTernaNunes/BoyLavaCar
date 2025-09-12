package br.com.boylavacar.BoyLavaCar.controller;

import br.com.boylavacar.BoyLavaCar.Domain.Agendamento.Service.FinalizarAgendamento;
import br.com.boylavacar.BoyLavaCar.Domain.Financeiro.DTOFormPagamento;
import br.com.boylavacar.BoyLavaCar.Domain.Financeiro.DTOPagamento;
import br.com.boylavacar.BoyLavaCar.Domain.Financeiro.Pagamento;
import br.com.boylavacar.BoyLavaCar.Domain.Financeiro.Repository.PagamentoRepository;
import br.com.boylavacar.BoyLavaCar.Domain.Financeiro.Service.ApagaPagamento;
import br.com.boylavacar.BoyLavaCar.Domain.Financeiro.Service.BuscaPagamento;
import br.com.boylavacar.BoyLavaCar.Domain.Financeiro.Service.SalvaPagamento;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class PagamentoController {

    @Autowired
    BuscaPagamento buscaPagamento;

    @Autowired
    SalvaPagamento salvaPagamento;

    @Autowired
    ApagaPagamento apagaPagamento;

    @Autowired
    FinalizarAgendamento finalizarAgendamento;

    @PostMapping("/pagamento")
    public ResponseEntity<Void> adicionaPagamento(@RequestBody @Valid DTOFormPagamento dados, Model model){
        salvaPagamento.gravaPagamento(dados);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/pagamento")
    public List<DTOPagamento> buscarPagamentos(@RequestParam Long agendamentoId) {
        return buscaPagamento.busca(agendamentoId);
    }

    @DeleteMapping("/pagamento/{id}")
    public ResponseEntity deletaPagamento(@PathVariable String id){
        apagaPagamento.apagar(Long.valueOf(id));
        return ResponseEntity.ok().build();
    }

    @PostMapping("/pagamento/finalizar")
    public void finalizar(@RequestBody Map<String, Long> dados){
        finalizarAgendamento.finalizar(dados.get("id"));
    }
}

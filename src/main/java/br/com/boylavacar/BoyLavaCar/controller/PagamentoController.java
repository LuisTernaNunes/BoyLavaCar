package br.com.boylavacar.BoyLavaCar.controller;

import br.com.boylavacar.BoyLavaCar.Domain.Financeiro.DTOFormPagamento;
import br.com.boylavacar.BoyLavaCar.Domain.Financeiro.Pagamento;
import br.com.boylavacar.BoyLavaCar.Domain.Financeiro.Repository.PagamentoRepository;
import br.com.boylavacar.BoyLavaCar.Domain.Financeiro.Service.SalvaPagamento;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PagamentoController {

    @Autowired
    PagamentoRepository pagamentoRepository;

    @Autowired
    SalvaPagamento salvaPagamento;

    @PostMapping("/pagamento")
    public ResponseEntity<Void> adicionaPagamento(@RequestBody @Valid DTOFormPagamento dados, Model model){
        salvaPagamento.gravaPagamento(dados);
        System.out.println("Passou");
        return ResponseEntity.ok().build();
    }

    @GetMapping("/pagamento")
    public List<Pagamento> buscarPagamentos(@RequestParam Long agendamentoId) {
        List<Pagamento> pagamentos = pagamentoRepository.findAllByAgendamento_Id(agendamentoId);
        return pagamentos;
    }
}

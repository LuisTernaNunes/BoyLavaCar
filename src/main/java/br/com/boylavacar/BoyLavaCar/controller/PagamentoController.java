package br.com.boylavacar.BoyLavaCar.controller;

import br.com.boylavacar.BoyLavaCar.Domain.Financeiro.DTOFormPagamento;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PagamentoController {

    @PostMapping("/pagamento")
    public ResponseEntity<Void> adicionaPagamento(@RequestBody @Valid DTOFormPagamento pagamento, Model model){
        System.out.println(pagamento);
        return ResponseEntity.ok().build();
    }
}

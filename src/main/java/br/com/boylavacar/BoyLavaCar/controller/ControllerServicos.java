package br.com.boylavacar.BoyLavaCar.controller;


import br.com.boylavacar.BoyLavaCar.Domain.Servicos.FormServico;
import br.com.boylavacar.BoyLavaCar.Domain.Servicos.Service.CadServico;
import br.com.boylavacar.BoyLavaCar.Domain.Servicos.Servico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControllerServicos {

    @Autowired
    CadServico cadServico;

    @PostMapping("/servicos")
    public ResponseEntity processarFormulario(@ModelAttribute @Valid FormServico dados) {
        cadServico.CadastraServico(dados);
        return ResponseEntity.ok().build();
    }
}

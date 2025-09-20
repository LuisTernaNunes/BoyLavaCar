package br.com.boylavacar.BoyLavaCar.controller;

import br.com.boylavacar.BoyLavaCar.Domain.Agendamento.DTO.DTOFormAgenda;
import br.com.boylavacar.BoyLavaCar.Domain.Agendamento.Service.*;
import br.com.boylavacar.BoyLavaCar.Domain.Categoria.DTOCategoria;
import br.com.boylavacar.BoyLavaCar.Domain.Datas.Service.DTOdata;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ControllerAgendamento {

    @Autowired
    AgendamentoData data;
    @Autowired
    AgendamentoCategoria categoria;

    @Autowired
    SalvaAgendamento salvaAgendamento;

    @GetMapping("/agendamento")
    public String mainPage(@RequestParam(name = "etapa", required = false, defaultValue = "5") String secao,
                           Model model) {
        List<DTOdata> datas = data.DiaDisponiveis();
        List<DTOCategoria> servs = categoria.BuscaCategoria();
        model.addAttribute("categorias",servs);
        model.addAttribute("datas", datas);
        model.addAttribute("marcado", false);
        return "agendamento";
    }

    @PostMapping("/agendamento")
    public ResponseEntity processarFormulario(@RequestBody @Valid DTOFormAgenda dados) {
        System.out.println(dados.nome());
        salvaAgendamento.Salvar(dados);
        return ResponseEntity.ok().build();
    }

}

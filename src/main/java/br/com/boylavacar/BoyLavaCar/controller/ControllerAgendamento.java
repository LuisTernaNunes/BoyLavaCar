package br.com.boylavacar.BoyLavaCar.controller;

import br.com.boylavacar.BoyLavaCar.Agendamento.DTO.DTOFormAgenda;
import br.com.boylavacar.BoyLavaCar.Agendamento.Service.AgendamentoCategoria;
import br.com.boylavacar.BoyLavaCar.Agendamento.Service.AgendamentoData;
import br.com.boylavacar.BoyLavaCar.Categoria.DTOCategoria;
import br.com.boylavacar.BoyLavaCar.Datas.Service.DTOdata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class ControllerAgendamento {
    @Autowired
    AgendamentoData data;
    @Autowired
    AgendamentoCategoria categoria;
    @GetMapping("/agendamento")
    public String mainPage(@RequestParam(name = "etapa", required = false, defaultValue = "5") String secao,
                           Model model) {
        DTOdata[] datas = data.DiaDisponiveis();
        DTOCategoria[] servs = categoria.BuscaCategoria();
        model.addAttribute("categorias",servs);
        model.addAttribute("datas", datas);
        return "agendamento";
    }

    @PostMapping("/agendamento")
    public String processarFormulario(@ModelAttribute DTOFormAgenda agendamento, Model model) {
        System.out.println("Categoria: " + agendamento.cat());
        System.out.println("servico: " + agendamento.servico());
        System.out.println("Nome: " + agendamento.nome());
        System.out.println("Telefone: " + agendamento.whatsapp());
        System.out.println("Data: " + agendamento.dia());
        System.out.println("Horário: " + agendamento.hora());

        model.addAttribute("fragmentPath", "fragments/_agendamento_confirmado");
        return "agendamento";
    }
}

package br.com.boylavacar.BoyLavaCar.controller;

import br.com.boylavacar.BoyLavaCar.Domain.Agendamento.Service.CarregaAgendamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerMain {
    @Autowired
    CarregaAgendamento carregaAgendamento;

    @GetMapping("/main")
    public String mainPage(@RequestParam(name = "secao", required = false, defaultValue = "Agendamentos") String secao,
                           Model model) {
        String fragmentPath;

        switch (secao) {
            case "Relatorios":
                fragmentPath = "fragments/_conteudo_relatorios";
                break;
            case "Configurações":
                fragmentPath = "fragments/_conteudo_configuracoes";
                break;
            case "Agendamentos":
            default:
                fragmentPath = "fragments/_conteudo_agendamentos";
                model.addAttribute("dados", carregaAgendamento.buscaAgendamento());
                break;
        }

        model.addAttribute("secao", secao);
        model.addAttribute("fragmentPath", fragmentPath);

        return "main";
    }
}

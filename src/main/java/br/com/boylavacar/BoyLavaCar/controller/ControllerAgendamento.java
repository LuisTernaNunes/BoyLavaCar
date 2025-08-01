package br.com.boylavacar.BoyLavaCar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerAgendamento {
    @GetMapping("/agendamento")
    public String mainPage(@RequestParam(name = "etapa", required = false, defaultValue = "6") String secao,
                           Model model) {
        String fragmentPath;
        switch (secao) {
            case "1":
                fragmentPath = "fragments/_agendamento_serv";
                break;
            case "2":
                fragmentPath = "fragments/_agendamento_data";
                break;
            case "3":
                fragmentPath = "fragments/_agendamento_dados";
                break;
            case "4":
                fragmentPath = "fragments/_agendamento_info";
                break;
            case "5":
                fragmentPath = "fragments/_agendamento_confirmado";
                break;
            case "6":
            default:
                fragmentPath = "fragments/_agendamento_cat";
                break;
        }
        model.addAttribute("etapa", secao);
        model.addAttribute("fragmentPath", fragmentPath);
        return "agendamento";
    }
}

package br.com.boylavacar.BoyLavaCar.controller;

import br.com.boylavacar.BoyLavaCar.Domain.Agendamento.Agendamento;
import br.com.boylavacar.BoyLavaCar.Domain.Agendamento.Service.CarregaAgendamento;
import br.com.boylavacar.BoyLavaCar.Domain.Categoria.CarregaCategorias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ControllerMain {
    @Autowired
    CarregaAgendamento carregaAgendamento;

    @Autowired
    CarregaCategorias carregaCategorias;


    @GetMapping("/main")
    public String mainPage(Model model) {
        String fragmentPath;
        fragmentPath = "fragments/_conteudo_agendamentos";
        model.addAttribute("dados", carregaAgendamento.buscaAgendamentoDia("Hoje"));
        model.addAttribute("secao", "Agendamentos");
        model.addAttribute("fragmentPath", fragmentPath);
        return "main";
    }

    @PostMapping("/main")
    public String filtrarAgendamentos(
        @RequestParam("filtro") String filtro, RedirectAttributes redirectAttrs) {
        redirectAttrs.addAttribute("filtro", filtro);
        return "redirect:/agendamentos";
    }

    @GetMapping("/agendamentos")
    public String filtraAgendamento(@RequestParam(required = false) String filtro, Model model){
        List<Agendamento> agendamentos = carregaAgendamento.buscaAgendamentoDia(filtro);
        model.addAttribute("dados", agendamentos);
        model.addAttribute("secao", "Agendamentos");
        model.addAttribute("fragmentPath", "fragments/_conteudo_agendamentos");
        return "main";
    }


}

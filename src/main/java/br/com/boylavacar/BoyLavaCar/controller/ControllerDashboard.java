package br.com.boylavacar.BoyLavaCar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerDashboard {
    @GetMapping("/dashboard")
    public String dashborad(Model model){
        String fragmentPath;
        fragmentPath = "fragments/_conteudo_dashboad";
        model.addAttribute("secao", "Dashboard");
        model.addAttribute("fragmentPath", fragmentPath);
        return "main";
    }
}

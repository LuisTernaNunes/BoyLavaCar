package br.com.boylavacar.BoyLavaCar.controller;

import br.com.boylavacar.BoyLavaCar.Domain.Categoria.CarregaCategorias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerConfiguracoes {
    @Autowired
    CarregaCategorias carregaCategorias;

    @GetMapping("configuracoes")
    public String carregaConfiguracoes(Model model){
        String fragmentPath;
        fragmentPath = "fragments/_conteudo_configuracoes";
        model.addAttribute("categorias", carregaCategorias.buscaCategorias());
        model.addAttribute("secao", "Configurações");
        model.addAttribute("fragmentPath", fragmentPath);
        return "main";
    }
}

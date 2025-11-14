package br.com.boylavacar.BoyLavaCar.controller;

import br.com.boylavacar.BoyLavaCar.Domain.Agendamento.Service.AgendamentoCategoria;
import br.com.boylavacar.BoyLavaCar.Domain.Agendamento.Service.AgendamentoData;
import br.com.boylavacar.BoyLavaCar.Domain.Agendamento.Service.SalvaAgendamento;
import br.com.boylavacar.BoyLavaCar.Domain.Categoria.DTOCategoria;
import br.com.boylavacar.BoyLavaCar.Domain.Datas.Service.DTOdata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ControllerAgendamentoManual {
    @Autowired
    AgendamentoData data;
    @Autowired
    AgendamentoCategoria categoria;

    @Autowired
    SalvaAgendamento salvaAgendamento;

    @GetMapping("agendamentomanual")
    public String carregaAgendamentoManual(Model model){
        String fragmentPath;
        fragmentPath = "fragments/_conteudo_agendamento_manual";
        List<DTOdata> datas = data.DiaDisponiveis();
        List<DTOCategoria> servs = categoria.BuscaCategoria();

        model.addAttribute("fragmentPath", fragmentPath);
        model.addAttribute("secao","AgendamentoManual");
        model.addAttribute("categorias",servs);
        model.addAttribute("datas", datas);
        model.addAttribute("marcado", false);

        return "main";
    }
}

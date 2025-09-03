package br.com.boylavacar.BoyLavaCar.controller;

import br.com.boylavacar.BoyLavaCar.Domain.Agendamento.Agendamento;
import br.com.boylavacar.BoyLavaCar.Domain.Agendamento.AgendamentoRepository;
import br.com.boylavacar.BoyLavaCar.Domain.Agendamento.DTO.DTOFormAgenda;
import br.com.boylavacar.BoyLavaCar.Domain.Agendamento.Service.AgendamentoCategoria;
import br.com.boylavacar.BoyLavaCar.Domain.Agendamento.Service.AgendamentoData;
import br.com.boylavacar.BoyLavaCar.Domain.Agendamento.Service.SalvaAgendamento;
import br.com.boylavacar.BoyLavaCar.Domain.Agendamento.Service.ValidaHorario;
import br.com.boylavacar.BoyLavaCar.Domain.Categoria.Categoria;
import br.com.boylavacar.BoyLavaCar.Domain.Categoria.CategoriaRepository;
import br.com.boylavacar.BoyLavaCar.Domain.Categoria.DTOCategoria;
import br.com.boylavacar.BoyLavaCar.Datas.Service.DTOdata;
import br.com.boylavacar.BoyLavaCar.Domain.Categoria.Service.BuscaCategoria;
import br.com.boylavacar.BoyLavaCar.Domain.Cliente.Cliente;
import br.com.boylavacar.BoyLavaCar.Domain.Cliente.Service.BuscaCliente;
import br.com.boylavacar.BoyLavaCar.Domain.Servicos.Service.BuscaServicos;
import br.com.boylavacar.BoyLavaCar.Domain.Servicos.Servico;
import br.com.boylavacar.BoyLavaCar.Domain.Servicos.ServicoRepository;
import br.com.boylavacar.BoyLavaCar.Suporte.ExibeDadosDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
public class ControllerAgendamento {

    @Autowired
    AgendamentoData data;
    @Autowired
    AgendamentoCategoria categoria;

    @Autowired
    SalvaAgendamento salvaAgendamento;

    @Autowired
    ExibeDadosDTO exibe;
    @GetMapping("/agendamento")
    public String mainPage(@RequestParam(name = "etapa", required = false, defaultValue = "5") String secao,
                           Model model) {
        DTOdata[] datas = data.DiaDisponiveis();
        List<DTOCategoria> servs = categoria.BuscaCategoria();
        model.addAttribute("categorias",servs);
        model.addAttribute("datas", datas);
        model.addAttribute("marcado", false);
        return "agendamento";
    }

    @PostMapping("/agendamento")
    public String processarFormulario(@ModelAttribute @Valid DTOFormAgenda dados, Model model) {

        salvaAgendamento.Salvar(dados);

        exibe.exibeAgendamento(dados);

        model.addAttribute("fragmentPath", "fragments/_agendamento_confirmado");
        return "agendamento";
    }
}

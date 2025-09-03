package br.com.boylavacar.BoyLavaCar.Domain.Agendamento.Service;

import br.com.boylavacar.BoyLavaCar.Domain.Agendamento.Agendamento;
import br.com.boylavacar.BoyLavaCar.Domain.Agendamento.AgendamentoRepository;
import br.com.boylavacar.BoyLavaCar.Domain.Agendamento.DTO.DTOFormAgenda;
import br.com.boylavacar.BoyLavaCar.Domain.Categoria.Categoria;
import br.com.boylavacar.BoyLavaCar.Domain.Categoria.Service.BuscaCategoria;
import br.com.boylavacar.BoyLavaCar.Domain.Cliente.Cliente;
import br.com.boylavacar.BoyLavaCar.Domain.Cliente.Service.BuscaCliente;
import br.com.boylavacar.BoyLavaCar.Domain.Servicos.Service.BuscaServicos;
import br.com.boylavacar.BoyLavaCar.Domain.Servicos.Servico;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class SalvaAgendamento {

    @Autowired
    BuscaCliente buscaCliente;

    @Autowired
    BuscaCategoria buscaCategoria;

    @Autowired
    BuscaServicos buscaServicos;

    @Autowired
    ValidaHorario validaHorario;

    @Autowired
    AgendamentoRepository agendamentoRepository;

    @Autowired
    AgendamentoStreamController stream;

    @Transactional
    public void Salvar(DTOFormAgenda dados){
        LocalDateTime data = validaHorario.valida(dados);
        Cliente cliente = buscaCliente.existeCliente(dados);
        Categoria cat = buscaCategoria.busca(dados);
        List<Servico> servicos = buscaServicos.busca(dados);
        Agendamento agendamento = new Agendamento(data,cliente,cat,servicos,dados.obs());
        agendamentoRepository.save(agendamento);
        stream.novoAgendamento();
    }
}

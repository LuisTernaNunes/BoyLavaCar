package br.com.boylavacar.BoyLavaCar.Domain.Servicos.Service;

import br.com.boylavacar.BoyLavaCar.Domain.Agendamento.DTO.DTOFormAgenda;
import br.com.boylavacar.BoyLavaCar.Domain.Servicos.Servico;
import br.com.boylavacar.BoyLavaCar.Domain.Servicos.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class BuscaServicos {
    @Autowired
    ServicoRepository servicoRepository;

    public List<Servico> busca(DTOFormAgenda dados){
        List<String> servicosId = Arrays.asList(dados.servico().split(","));
        List<Servico> sevicos = new ArrayList<>();
        for (int i = 0; i < servicosId.size(); i++) {
            Optional<Servico> ser =  servicoRepository.findById(Long.valueOf(servicosId.get(i)));
            sevicos.add(ser.get());
        }
        return sevicos;
    }
}

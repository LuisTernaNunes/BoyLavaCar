package br.com.boylavacar.BoyLavaCar.Domain.Agendamento.Service;

import br.com.boylavacar.BoyLavaCar.Domain.Categoria.Categoria;
import br.com.boylavacar.BoyLavaCar.Domain.Categoria.CategoriaRepository;
import br.com.boylavacar.BoyLavaCar.Domain.Categoria.DTOCategoria;
import br.com.boylavacar.BoyLavaCar.Domain.Servicos.DTOServ;
import br.com.boylavacar.BoyLavaCar.Domain.Servicos.Servico;
import br.com.boylavacar.BoyLavaCar.Domain.Servicos.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class AgendamentoCategoria {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    ServicoRepository servicoRepository;

    public List<DTOCategoria> BuscaCategoria(){

        List<Categoria> categorias = categoriaRepository.findAll();

        return convertDTO(categorias);
    }

    public List<DTOCategoria> convertDTO(List<Categoria> cat){
        List<DTOCategoria> categoriasDTO = new ArrayList<>();
        for (int i = 0; i < cat.size(); i++) {
            categoriasDTO.add( new DTOCategoria(Math.toIntExact(cat.get(i).getId()), cat.get(i).getNome(), buscaServ(cat.get(i).getId())));
        }
        return categoriasDTO;
    }

    public List<DTOServ> buscaServ(Long id){
        List<Servico> servicos = servicoRepository.findAll();

        List<DTOServ> servicosDTO = new ArrayList<>();

        for (int i = 0; i < servicos.size(); i++) {
            if(Objects.equals(servicos.get(i).getCategoria().getId(), id)){
                servicosDTO.add( new DTOServ(Math.toIntExact(servicos.get(i).getId()),servicos.get(i).getNome(),servicos.get(i).getValor()));
            }
        }
        return servicosDTO;
    }

}

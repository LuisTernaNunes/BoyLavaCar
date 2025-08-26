package br.com.boylavacar.BoyLavaCar.Domain.Categoria.Service;

import br.com.boylavacar.BoyLavaCar.Domain.Agendamento.DTO.DTOFormAgenda;
import br.com.boylavacar.BoyLavaCar.Domain.Categoria.Categoria;
import br.com.boylavacar.BoyLavaCar.Domain.Categoria.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuscaCategoria {
    @Autowired
    CategoriaRepository categoriaRepository;

    public Categoria busca(DTOFormAgenda dados){
       Optional<Categoria> cat = categoriaRepository.findById(Long.valueOf(dados.cat()));
       return cat.get();
    }
}

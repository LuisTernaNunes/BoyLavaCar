package br.com.boylavacar.BoyLavaCar.Domain.Categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarregaCategorias {
    @Autowired
    CategoriaRepository categoriaRepository;
    public List<Categoria> buscaCategorias(){
        List<Categoria> categorias = categoriaRepository.findAll();
        return categorias;
    }
}

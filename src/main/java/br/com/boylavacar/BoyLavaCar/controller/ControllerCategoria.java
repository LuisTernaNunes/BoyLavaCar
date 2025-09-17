package br.com.boylavacar.BoyLavaCar.controller;

import br.com.boylavacar.BoyLavaCar.Domain.Categoria.Categoria;
import br.com.boylavacar.BoyLavaCar.Domain.Categoria.CategoriaRepository;
import br.com.boylavacar.BoyLavaCar.Domain.Categoria.FormCategoria;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ControllerCategoria {
    @Autowired
    CategoriaRepository categoriaRepository;

    @PostMapping("/categoria")
    public ResponseEntity processarFormulario(@ModelAttribute @Valid FormCategoria dados) {
        Categoria categoria = new Categoria(dados);
        categoriaRepository.save(categoria);
        return ResponseEntity.ok().build();
    }
}

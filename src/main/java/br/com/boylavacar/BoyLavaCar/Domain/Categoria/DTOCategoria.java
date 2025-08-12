package br.com.boylavacar.BoyLavaCar.Domain.Categoria;

import br.com.boylavacar.BoyLavaCar.Domain.Servicos.DTOServ;

import java.util.List;

public record DTOCategoria(Integer id, String nome, List<DTOServ> servicos) {

}

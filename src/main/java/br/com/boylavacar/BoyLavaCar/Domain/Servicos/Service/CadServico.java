package br.com.boylavacar.BoyLavaCar.Domain.Servicos.Service;

import br.com.boylavacar.BoyLavaCar.Domain.Categoria.Categoria;
import br.com.boylavacar.BoyLavaCar.Domain.Categoria.CategoriaRepository;
import br.com.boylavacar.BoyLavaCar.Domain.Servicos.FormServico;
import br.com.boylavacar.BoyLavaCar.Domain.Servicos.Servico;
import br.com.boylavacar.BoyLavaCar.Domain.Servicos.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadServico {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    ServicoRepository servicoRepository;

    public void CadastraServico(FormServico dados){
        var categoria = categoriaRepository.findById(Long.valueOf(dados.categoriaId()));
        Servico servico = new Servico(dados,categoria);
        servicoRepository.save(servico);
    }
}

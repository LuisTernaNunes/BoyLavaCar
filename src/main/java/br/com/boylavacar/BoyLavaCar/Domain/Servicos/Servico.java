package br.com.boylavacar.BoyLavaCar.Domain.Servicos;

import br.com.boylavacar.BoyLavaCar.Domain.Categoria.Categoria;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.math.BigDecimal;
import java.util.Optional;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Double valor;

    @ManyToOne
    private Categoria categoria;

    public Servico(@Valid FormServico dados, Optional<Categoria> categoria) {
        this.categoria = categoria.get();
        this.nome = dados.nome();
        this.valor = Double.valueOf(dados.valor());
    }

}

package br.com.boylavacar.BoyLavaCar.Domain.Servicos;

import br.com.boylavacar.BoyLavaCar.Domain.Categoria.Categoria;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
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
}

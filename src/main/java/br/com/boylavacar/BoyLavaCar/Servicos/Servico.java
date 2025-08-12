package br.com.boylavacar.BoyLavaCar.Servicos;

import br.com.boylavacar.BoyLavaCar.Categoria.Categoria;
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
    @Id @GeneratedValue
    private Long id;

    private String nome;

    private BigDecimal valor;

    @ManyToOne
    private Categoria categoria;
}

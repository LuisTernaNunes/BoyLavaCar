package br.com.boylavacar.BoyLavaCar.Domain.Categoria;

import br.com.boylavacar.BoyLavaCar.Domain.Servicos.Servico;
import jakarta.persistence.*;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Categoria {
    @Id @GeneratedValue
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "categoria")
    private List<Servico> servicos;

}

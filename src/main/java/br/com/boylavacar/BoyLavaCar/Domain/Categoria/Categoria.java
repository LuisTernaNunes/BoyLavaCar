package br.com.boylavacar.BoyLavaCar.Domain.Categoria;

import br.com.boylavacar.BoyLavaCar.Domain.Servicos.Servico;
import jakarta.persistence.*;

import jakarta.validation.Valid;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "categoria")
    private List<Servico> servicos;

    public Categoria(@Valid FormCategoria dados) {
        this.nome = dados.nomeCategoria();
    }
}

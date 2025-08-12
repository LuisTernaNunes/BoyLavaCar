package br.com.boylavacar.BoyLavaCar.Agendamento;

import br.com.boylavacar.BoyLavaCar.Categoria.Categoria;
import br.com.boylavacar.BoyLavaCar.Cliente.Cliente;
import br.com.boylavacar.BoyLavaCar.Servicos.Servico;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Agendamento {
    @Id @GeneratedValue
    private Long id;

    private LocalDateTime dataAgendamento;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Categoria categoria;

    @ManyToMany
    private List<Servico> servicosSelecionados;

}


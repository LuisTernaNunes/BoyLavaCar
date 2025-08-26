package br.com.boylavacar.BoyLavaCar.Domain.Agendamento;

import br.com.boylavacar.BoyLavaCar.Domain.Categoria.Categoria;
import br.com.boylavacar.BoyLavaCar.Domain.Cliente.Cliente;
import br.com.boylavacar.BoyLavaCar.Domain.Financeiro.Pagamento;
import br.com.boylavacar.BoyLavaCar.Domain.Servicos.Servico;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataAgendamento;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Categoria categoria;

    @ManyToMany
    private List<Servico> servicosSelecionados;

    @OneToMany(mappedBy = "agendamento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pagamento> pagamentos;

    @Enumerated(EnumType.STRING)
    private StatusAgendamento status;

    private Double valorTotal;

    private String observacao;

    public Agendamento(LocalDateTime data, Cliente cliente, Categoria cat, List<Servico> servicos,String obs) {
        this.dataAgendamento = data;
        this.cliente = cliente;
        this.categoria = cat;
        this.servicosSelecionados = servicos;
        this.status = StatusAgendamento.ABERTO;
        this.valorTotal = servicos.stream()
                .mapToDouble(Servico::getValor)
                .sum();
        this.observacao = obs;
    }
}


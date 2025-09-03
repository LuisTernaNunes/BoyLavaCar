package br.com.boylavacar.BoyLavaCar.Domain.Financeiro;

import br.com.boylavacar.BoyLavaCar.Domain.Agendamento.Agendamento;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double valor;
    private LocalDateTime dataPagamento;
    @Enumerated(EnumType.STRING)
    private FormaPagamento forma;
    @Enumerated(EnumType.STRING)
    private StatusPagamento status;
    @ManyToOne
    @JoinColumn(name = "caixa_id")
    @JsonIgnore
    private Caixa caixa;
    @ManyToOne
    @JoinColumn(name = "agendamento_id")
    @JsonIgnore
    private Agendamento agendamento;

    public Pagamento(DTOFormPagamento dados, Caixa caixa, Agendamento agendamento) {
        this.caixa = caixa;
        this.agendamento = agendamento;
        this.valor = Double.valueOf(dados.valorPagamento());
        this.dataPagamento = LocalDateTime.now();
        this.forma = FormaPagamento.fromString(dados.formaPagamento());
        this.status = StatusPagamento.PENDENTE;
    }
}

package br.com.boylavacar.BoyLavaCar.Domain.Financeiro;

import br.com.boylavacar.BoyLavaCar.Domain.Agendamento.Agendamento;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
    private BigDecimal valor;
    private LocalDateTime dataPagamento;
    @Enumerated(EnumType.STRING)
    private FormaPagamento forma;
    @Enumerated(EnumType.STRING)
    private StatusPagamento status;
    @ManyToOne
    @JoinColumn(name = "caixa_id")
    private Caixa caixa;
    @ManyToOne
    @JoinColumn(name = "agendamento_id")
    private Agendamento agendamento;
}

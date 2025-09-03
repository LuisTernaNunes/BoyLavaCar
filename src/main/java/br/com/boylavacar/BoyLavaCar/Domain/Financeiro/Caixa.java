package br.com.boylavacar.BoyLavaCar.Domain.Financeiro;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Caixa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;
    private BigDecimal saldoInicial;
    private BigDecimal saldoFinal;
    @OneToMany(mappedBy = "caixa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Pagamento> pagamentos;
    @Enumerated(EnumType.STRING)
    private StatusCaixa status;

    public void adicionaPagamentoCaixa(String valor){
        this.saldoFinal = this.saldoFinal.add(new BigDecimal(valor));
    }
}


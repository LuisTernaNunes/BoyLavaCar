package br.com.boylavacar.BoyLavaCar.Domain.Cliente;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Cliente {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String telefone;
}

package br.com.boylavacar.BoyLavaCar.Domain.Cliente;

import br.com.boylavacar.BoyLavaCar.Domain.Agendamento.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {

}
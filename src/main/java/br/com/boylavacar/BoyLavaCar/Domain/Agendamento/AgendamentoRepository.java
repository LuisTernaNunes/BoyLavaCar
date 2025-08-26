package br.com.boylavacar.BoyLavaCar.Domain.Agendamento;


import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface AgendamentoRepository extends JpaRepository<Agendamento,Long> {

    boolean existsByDataAgendamento(LocalDateTime dataHora);

}


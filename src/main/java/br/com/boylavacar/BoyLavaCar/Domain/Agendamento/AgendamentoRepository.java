package br.com.boylavacar.BoyLavaCar.Domain.Agendamento;


import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento,Long> {

    boolean existsByDataAgendamento(LocalDateTime dataHora);

    List<Agendamento> findByStatus(StatusAgendamento status);

    List<Agendamento> findByStatusAndDataAgendamentoBetween(StatusAgendamento statusAgendamento, LocalDateTime inicio, LocalDateTime fim);
}


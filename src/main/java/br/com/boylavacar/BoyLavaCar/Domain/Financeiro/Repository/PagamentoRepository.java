package br.com.boylavacar.BoyLavaCar.Domain.Financeiro.Repository;

import br.com.boylavacar.BoyLavaCar.Domain.Financeiro.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PagamentoRepository extends JpaRepository<Pagamento,Long> {
    List<Pagamento> findAllByAgendamento_Id(Long agendamentoId);
}

package br.com.boylavacar.BoyLavaCar.Domain.Financeiro.Repository;

import br.com.boylavacar.BoyLavaCar.Domain.Financeiro.Caixa;
import br.com.boylavacar.BoyLavaCar.Domain.Financeiro.Pagamento;
import br.com.boylavacar.BoyLavaCar.Domain.Financeiro.StatusCaixa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CaixaRepository extends JpaRepository<Caixa,Long> {

    Optional<Caixa> findByStatus(StatusCaixa statusCaixa);
}

package br.com.boylavacar.BoyLavaCar.Domain.Servicos;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServicoRepository extends JpaRepository<Servico,Long> {
}

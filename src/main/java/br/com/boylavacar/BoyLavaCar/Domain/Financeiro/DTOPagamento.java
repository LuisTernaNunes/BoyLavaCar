package br.com.boylavacar.BoyLavaCar.Domain.Financeiro;

public record DTOPagamento(Long id, Long idAgendamento, FormaPagamento metodo, Double valor) {
}

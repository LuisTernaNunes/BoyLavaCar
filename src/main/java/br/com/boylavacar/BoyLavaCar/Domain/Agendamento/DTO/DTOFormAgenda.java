package br.com.boylavacar.BoyLavaCar.Domain.Agendamento.DTO;

import java.util.List;

public record DTOFormAgenda(String categoria, List<String> servico, String nome, String whats, String dia , String hora, String obs) {
}

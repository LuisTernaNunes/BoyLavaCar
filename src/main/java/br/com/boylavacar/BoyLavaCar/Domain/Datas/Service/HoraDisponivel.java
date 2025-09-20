package br.com.boylavacar.BoyLavaCar.Domain.Datas.Service;

import java.time.LocalTime;
import java.util.List;

public record HoraDisponivel(LocalTime hora, Boolean disponibilidade) {
}

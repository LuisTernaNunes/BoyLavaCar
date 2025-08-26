package br.com.boylavacar.BoyLavaCar.Datas.Service;

import java.time.LocalTime;
import java.util.List;

public record HoraDisponivel(LocalTime hora, Boolean disponibilidade) {
}

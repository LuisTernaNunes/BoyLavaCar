package br.com.boylavacar.BoyLavaCar.Agendamento.Service;

import br.com.boylavacar.BoyLavaCar.Datas.Service.DTOdata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AgendamentoData {

    public DTOdata[] DiaDisponiveis() {
        DTOdata[] dias = new DTOdata[5]; // Corrigido: tamanho 5
        LocalDate hoje = LocalDate.now();

        for (int i = 0; i < 5; i++) {
            LocalDate data = hoje.plusDays(i);
            List<LocalTime> horas = new ArrayList<>();

            for (int j = 8; j < 17; j++) {
                horas.add(LocalTime.of(j, 0));
            }

            dias[i] = new DTOdata(data, horas);
        }
        return dias;
    }
}

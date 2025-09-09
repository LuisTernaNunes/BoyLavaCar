package br.com.boylavacar.BoyLavaCar.Suporte;

import br.com.boylavacar.BoyLavaCar.Domain.Agendamento.DTO.DTOFormAgenda;
import org.springframework.stereotype.Service;

@Service
public class ExibeDadosDTO {
    public void exibeAgendamento(DTOFormAgenda agendamento){
        System.out.println("Categoria: " + agendamento.categoria());
        System.out.println("servico: " + agendamento.servico());
        System.out.println("Nome: " + agendamento.nome());
        System.out.println("Telefone: " + agendamento.whats());
        System.out.println("Data: " + agendamento.dia());
        System.out.println("Horário: " + agendamento.hora());
    }
}

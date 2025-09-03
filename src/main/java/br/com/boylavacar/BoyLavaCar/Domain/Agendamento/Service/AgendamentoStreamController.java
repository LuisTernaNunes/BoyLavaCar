package br.com.boylavacar.BoyLavaCar.Domain.Agendamento.Service;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@RestController
public class AgendamentoStreamController {

    private final Sinks.Many<String> sink;

    public AgendamentoStreamController() {
        this.sink = Sinks.many().multicast().directAllOrNothing();
    }

    // Endpoint SSE
    @GetMapping(value = "/agendamentos/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> streamAgendamentos() {
        return sink.asFlux();
    }

    // Método para emitir evento quando novo agendamento for criado
    public void novoAgendamento() {
        sink.tryEmitNext("Novo agendamento!");
    }
}
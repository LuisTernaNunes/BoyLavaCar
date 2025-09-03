if ("EventSource" in window) {
    const eventSource = new EventSource("/agendamentos/stream");

    eventSource.onmessage = function(event) {
        console.log("Novo agendamento recebido:", event.data);
        // Recarrega a página inteira
        window.location.reload();
    };

    eventSource.onerror = function(err) {
        console.error("Erro SSE:", err);
    };
}

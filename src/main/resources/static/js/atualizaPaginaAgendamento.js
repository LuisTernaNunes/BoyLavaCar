if ("EventSource" in window) {
    const eventSource = new EventSource("/agendamentos/stream");

    eventSource.onmessage = function(event) {
        window.location.href = "main?secao=Agendamentos";
    };

    eventSource.onerror = function(err) {
        console.error("Erro SSE:", err);
    };
}

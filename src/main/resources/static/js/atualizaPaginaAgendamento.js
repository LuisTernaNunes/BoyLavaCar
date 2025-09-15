if ("EventSource" in window) {
    const eventSource = new EventSource("/agendamentos/stream");

    eventSource.onmessage = function(event) {

        const audio = new Audio("/sons/notificacao.mp3");
        audio.play();
        setTimeout(() => {
                window.location.href = "/main?secao=Agendamentos";
            }, 500);
    };

    eventSource.onerror = function(err) {
        console.error("Erro SSE:", err);
    };
}

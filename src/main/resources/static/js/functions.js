function mostrarEtapa(etapa) {
    const etapas = ["categoria", "servico", "data", "dados", "confirmacao", "confirmado"];

    console.log(etapa);
    switch (etapa) {
            case "servico":
                if (!document.querySelector('input[name="cat"]:checked')) {
                    alert("Escolha uma categoria antes de prosseguir!");
                    return;
                }
                break;

            case "data":
                if (document.querySelectorAll('input[name="servico"]:checked').length === 0) {
                    alert("Escolha pelo menos um serviço antes de prosseguir!");
                    return;
                }
                break;

            case "dados":
                const dia = document.getElementsByName("dia")[0].value;
                const hora = document.getElementsByName("hora")[0].value;
                if (!dia || !hora) {
                    alert("Escolha dia e hora antes de prosseguir!");
                    return;
                }
                break;

            case "confirmacao":
                const nome = document.getElementById("nome").value;
                const whats = document.getElementById("whats").value;
                if (!nome || !whats) {
                    alert("Preencha nome e WhatsApp antes de confirmar!");
                    return;
                }
                break;
    }

    etapas.forEach(id => {
        const bloco = document.getElementById(id);
        if (bloco) bloco.classList.add("d-none");
    });

    const bloco = document.getElementById(etapa);
    if (bloco) bloco.classList.remove("d-none");
}

function enviaAgendamento(){

    let agendamento = recuperaDados();

    fetch("/agendamento", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(agendamento)
        })
}

function mostrarInfo(){


    let agendamento = recuperaDados();

    var nome = document.getElementById("nome").value;
    var whats = document.getElementById("whats").value;
    var dia = document.getElementsByName("dia")[0].value;
    var hora = document.getElementsByName("hora")[0].value;
    var obs = document.getElementById("obs").value;

    let partes = dia.split("-"); // ["2025", "08", "07"]
    let formatada = partes[2] + "/" + partes[1]; // "07/08"

    var data = formatada + " as " + hora;

    document.getElementById("infoNome").innerText = nome;
    document.getElementById("infoWhats").innerText = whats;
    document.getElementById("infoData").innerText = data;

}

function somaServco(checkbox){
    var tot = document.getElementById("valorTotal").innerText;
    var total = parseInt(tot);
     if (checkbox.checked) {
        total = total + parseInt(checkbox.dataset.valor);
     } else {
        total = total - parseInt(checkbox.dataset.valor);
     }

     document.getElementById("valorTotal").innerText = total;
     document.getElementById("infoValor").innerText = total.toLocaleString('pt-BR', { style: 'currency', currency: 'BRL' });;
}

function recuperaDados(){
    let servicosSelecionados = Array.from(document.querySelectorAll('input[name="servico"]:checked'))
                                    .map(cb => cb.value);

    let agendamento = {
        categoria: document.querySelector('input[name="cat"]:checked')?.value || "", // radio
        servico: servicosSelecionados,
        nome: document.getElementById("nome").value,
        whats: document.getElementById("whats").value,
        dia: document.querySelector('input[name="dia"]:checked')?.value,
        hora: document.querySelector('input[name="hora"]:checked')?.value,
        obs: document.getElementById("obs").value
    };
    console.log(agendamento);
    return agendamento;
}

function filtrarAgendamento(dia){
 console.log(dia)
}


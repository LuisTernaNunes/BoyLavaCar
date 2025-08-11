function mostrarEtapa(numero) {
                const totalEtapas = 6;

                for (let i = 1; i <= totalEtapas; i++) {
                    const bloco = document.getElementById('etapa' + i);
                    if (bloco) {
                        bloco.classList.add('d-none');
                    }
                }
                const atual = document.getElementById('etapa' + numero);
                if (atual) {
                    atual.classList.remove('d-none');
                }
                // Controla o botão final
                const botaoFinal = document.getElementById('botaoFinal');
                if (botaoFinal) {
                    if(numero == 5){
                        botaoFinal.classList.remove('d-none');
                    }
                }
            }
function mostrarInfo(){
    var nome = document.getElementById("nome").value;
    var whats = document.getElementById("whats").value;
    var dia = document.getElementsByName("dia")[0].value;
    var hora = document.getElementsByName("hora")[0].value;

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
}



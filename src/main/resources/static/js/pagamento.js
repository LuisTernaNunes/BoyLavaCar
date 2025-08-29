let pagamentosPorModal = {};

function adicionarPagamento(index,valorTotal,idAgendamento) {
    const metodo = document.querySelector(`input[name="pagamento${index}"]:checked`);
    const valor = document.getElementById("valorPagamento" + index).value;

    if (!metodo || !valor) {
        alert("Selecione o método e informe o valor.");
        return;
    }

    if (!pagamentosPorModal[index]) {
        pagamentosPorModal[index] = [];
    }

    pagamentosPorModal[index].push({ metodo: metodo.value, valor });

    atualizarTabela(index);
    vereficaPagamento(index,valorTotal);

    fetch("/pagamento", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ idAgendamento: idAgendamento, formaPagamento: metodo.value, valorPagamento: valor })
    })
    .then(res => {
        if (res.ok) {
            console.log("Pagamento salvo com sucesso!");
        } else {
            console.error("Erro ao salvar pagamento:", res.status);
        }
    })
    .catch(err => console.error("Erro de rede:", err));
    document.getElementById("valorPagamento" + index).value = "";
}

function removerPagamento(modalIndex, pagamentoIndex) {
    pagamentosPorModal[modalIndex].splice(pagamentoIndex, 1);
    atualizarTabela(modalIndex);
}

function atualizarTabela(index) {
    const lista = document.getElementById("tabela" + index);
    lista.innerHTML = "";

    (pagamentosPorModal[index] || []).forEach((p, i) => {
        lista.innerHTML += `
            <tr>
                <td>${p.metodo}</td>
                <td>R$ ${parseFloat(p.valor).toFixed(2)}</td>
                <td>
                    <button type="button"
                            class="btn btn-danger btn-sm"
                            onclick="removerPagamento(${index}, ${i})">
                        Remover
                    </button>
                </td>
            </tr>
        `;
    });

    // document.getElementById("pagamentosInput" + index).value = JSON.stringify(pagamentosPorModal[index]);
}

function vereficaPagamento(index,valorTotal){
    let total = 0;
        pagamentosPorModal[index].forEach(p => {
            total += Number(p.valor);
        });

        const botaoFinalizar = document.getElementById("finalizar" + index);
        botaoFinalizar.blur();
        botaoFinalizar.disabled = Math.abs(total - valorTotal) >= 0.01;
}

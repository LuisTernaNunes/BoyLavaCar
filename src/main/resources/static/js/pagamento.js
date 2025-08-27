// Cada modal vai ter seu próprio array de pagamentos
let pagamentosPorModal = {};

function adicionarPagamento(index) {
    const metodo = document.querySelector(`input[name="pagamento${index}"]:checked`);
    const valor = document.getElementById("valorPagamento" + index).value;

    if (!metodo || !valor) {
        alert("Selecione o método e informe o valor.");
        return;
    }

    // Se não existir ainda, cria a lista para este modal
    if (!pagamentosPorModal[index]) {
        pagamentosPorModal[index] = [];
    }

    // Adiciona pagamento no modal correto
    pagamentosPorModal[index].push({ metodo: metodo.value, valor });

    atualizarTabela(index);
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

    // Se quiser enviar para o backend (campo hidden específico por modal)
    // document.getElementById("pagamentosInput" + index).value = JSON.stringify(pagamentosPorModal[index]);
}

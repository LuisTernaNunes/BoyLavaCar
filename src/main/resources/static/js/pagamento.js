const pagamentosAtuais = {}; // Mantém os pagamentos temporários por modal

// Adicionar pagamento
function adicionarPagamento(index, idAgendamento) {
    const metodoInput = document.querySelector(`input[name="pagamento${index}"]:checked`);
    const valorInput = document.getElementById("valorPagamento" + index).value;

    console.log(idAgendamento);

    if (!metodoInput || !valorInput) {
        alert("Selecione o método e informe o valor.");
        return;
    }

    if (!pagamentosAtuais[index]) pagamentosAtuais[index] = [];

    pagamentosAtuais[index].push({
        metodo: metodoInput.value,
        valor: parseFloat(valorInput)
    });

    atualizarTabela(index);
    verificaPagamento(index);

    fetch("/pagamento", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
            idAgendamento,
            formaPagamento: metodoInput.value,
            valorPagamento: parseFloat(valorInput)
        })
    })
    .then(res => {
        if (res.ok) console.log("Pagamento salvo com sucesso!");
        else console.error("Erro ao salvar pagamento:", res.status);
    })
    .catch(err => console.error("Erro de rede:", err));

    document.getElementById("valorPagamento" + index).value = "";
}

// Atualizar tabela de pagamentos
function atualizarTabela(index) {
    const lista = document.getElementById("tabela" + index);
    lista.innerHTML = "";

    const pagamentos = pagamentosAtuais[index] || [];

    pagamentos.forEach((p, i) => {
        lista.innerHTML += `
            <tr>
                <td>${p.metodo}</td>
                <td>R$ ${p.valor.toFixed(2)}</td>
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
}

// Verifica botão Finalizar

function verificaPagamento(index) {
    const valorTotal = parseFloat(
        document.getElementById("valorTotal" + index).textContent.replace(',', '.')
    );

    const pagamentos = pagamentosAtuais[index] || [];
    const total = pagamentos.reduce((acc, p) => acc + p.valor, 0);

    const botaoFinalizar = document.getElementById("finalizar" + index);
    const adicionarPagamentoBtn = document.getElementById("adicionarPagamento" + index);

    // Se o total já bateu com o valor do agendamento, desabilita adicionar
    adicionarPagamentoBtn.disabled = total >= valorTotal;

    console.log(total);
    console.log(document.getElementById("valorTotal" + index).textContent);

    // Botão finalizar habilitado somente se houver pagamentos e total bate
    botaoFinalizar.blur();
    botaoFinalizar.disabled = pagamentos.length === 0 || Math.abs(total - valorTotal) >= 0.01;
}



// Buscar pagamentos do backend ao abrir modal
function buscaDados(index, idAgendamento) {
    pagamentosAtuais[index] = []; // Reseta array do modal

    fetch(`/pagamento?agendamentoId=${idAgendamento}`)
        .then(res => {
            if (!res.ok) throw new Error(`Erro na requisição: ${res.status}`);
            return res.json();
        })
        .then(data => {
            data.forEach(p => {
                pagamentosAtuais[index].push({
                    metodo: p.forma,
                    valor: parseFloat(p.valor)
                });
            });
            atualizarTabela(index);
            verificaPagamento(index);
        })
        .catch(err => console.error("Erro no fetch:", err));
}

// Remover pagamento
function removerPagamento(index, i) {
    if (!pagamentosAtuais[index]) return;

    const pagamentoRemovido = pagamentosAtuais[index].splice(i, 1)[0];

    // Atualiza UI e botão
    atualizarTabela(index);
    verificaPagamento(index);

    // Opcional: remover também do backend
    fetch(`/pagamento/${pagamentoRemovido.id}`, {
        method: "DELETE"
    })
    .then(res => {
        if (!res.ok) console.error("Erro ao remover pagamento:", res.status);
    })
    .catch(err => console.error("Erro de rede:", err));
}

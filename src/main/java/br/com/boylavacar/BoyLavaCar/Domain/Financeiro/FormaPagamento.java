package br.com.boylavacar.BoyLavaCar.Domain.Financeiro;

public enum FormaPagamento {
    PIX("Pix"),
    DEBITO("Débito"),
    CREDITO("Crédito"),
    DINHEIRO("Dinheiro");

    private final String valor;

    FormaPagamento(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public static FormaPagamento fromString(String valor) {
        for (FormaPagamento m : FormaPagamento.values()) {
            if (m.valor.equalsIgnoreCase(valor)) {
                return m;
            }
        }
        throw new IllegalArgumentException("Método de pagamento inválido: " + valor);
    }
    }

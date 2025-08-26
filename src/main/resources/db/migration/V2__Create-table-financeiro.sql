-- ============================
-- Criar tabela CAIXA
-- ============================
CREATE TABLE caixa (
    id BIGINT NOT NULL AUTO_INCREMENT,
    data DATE NOT NULL,
    saldo_inicial DECIMAL(19,2) NOT NULL,
    saldo_final DECIMAL(19,2),
    status VARCHAR(20) NOT NULL, -- ABERTO ou FECHADO
    PRIMARY KEY (id)
);

-- ============================
-- Criar tabela PAGAMENTO
-- ============================
CREATE TABLE pagamento (
    id BIGINT NOT NULL AUTO_INCREMENT,
    valor DECIMAL(19,2) NOT NULL,          -- valor parcial ou total
    data_pagamento DATETIME(6) NOT NULL,   -- quando foi feito
    forma VARCHAR(20) NOT NULL,            -- DINHEIRO, PIX, CARTAO_CREDITO, CARTAO_DEBITO
    status VARCHAR(20) NOT NULL,           -- PENDENTE, CONCLUIDO, CANCELADO
    caixa_id BIGINT,
    agendamento_id BIGINT NOT NULL,
    PRIMARY KEY (id)
);

-- ============================
-- Adicionar chaves estrangeiras
-- ============================
ALTER TABLE pagamento
    ADD CONSTRAINT fk_pagamento_caixa FOREIGN KEY (caixa_id) REFERENCES caixa (id);

ALTER TABLE pagamento
    ADD CONSTRAINT fk_pagamento_agendamento FOREIGN KEY (agendamento_id) REFERENCES agendamento (id);

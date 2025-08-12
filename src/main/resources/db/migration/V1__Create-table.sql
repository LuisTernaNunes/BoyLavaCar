CREATE TABLE categoria (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE cliente (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255),
    telefone VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE servico (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255),
    valor DECIMAL(19,2),
    categoria_id BIGINT,
    PRIMARY KEY (id),
    CONSTRAINT fk_servico_categoria FOREIGN KEY (categoria_id) REFERENCES categoria (id)
);

CREATE TABLE agendamento (
    id BIGINT NOT NULL AUTO_INCREMENT,
    data_agendamento DATETIME(6),
    cliente_id BIGINT,
    categoria_id BIGINT,
    PRIMARY KEY (id),
    CONSTRAINT fk_agendamento_cliente FOREIGN KEY (cliente_id) REFERENCES cliente (id),
    CONSTRAINT fk_agendamento_categoria FOREIGN KEY (categoria_id) REFERENCES categoria (id)
);

CREATE TABLE agendamento_servicos_selecionados (
    agendamento_id BIGINT NOT NULL,
    servicos_selecionados_id BIGINT NOT NULL,
    PRIMARY KEY (agendamento_id, servicos_selecionados_id),
    CONSTRAINT fk_agendamento_servicos_agendamento FOREIGN KEY (agendamento_id) REFERENCES agendamento (id),
    CONSTRAINT fk_agendamento_servicos_servico FOREIGN KEY (servicos_selecionados_id) REFERENCES servico (id)
);

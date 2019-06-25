-- SETOR
-- * codigo
-- * descricao

CREATE SEQUENCE seq_setor

CREATE TABLE setor (
    id NUMBER CONSTRAINT pksetor PRIMARY KEY,
    codigo VARCHAR(255),
    descricao VARCHAR(255)
)

-- Vendedor
-- * nome
-- * email
-- * gerente

CREATE SEQUENCE seq_vendedor

CREATE TABLE vendedor (
    id NUMBER CONSTRAINT pkvendedor PRIMARY KEY, 
    nome VARCHAR(255),
    email VARCHAR(255),
    gerente NUMBER
)

-- Serviço
-- * descricao
-- * dataFim
-- * dataInicio

CREATE SEQUENCE seq_servico

CREATE TABLE servico (
    id NUMBER CONSTRAINT pkservico PRIMARY KEY, 
    descricao VARCHAR(255),
    dataFim DATE,
    dataInicio DATE
)

-- EMPRESA
-- * razaoSocial
-- * nomeFantasia
-- * cidade
-- * site

CREATE SEQUENCE seq_empresa

CREATE TABLE empresa (
    id NUMBER CONSTRAINT pkempresa PRIMARY KEY, 
    razao_social VARCHAR(255),
    nome_fantasia VARCHAR(255),
    cidade VARCHAR(255),
    site VARCHAR(255),
    atual NUMBER,
    setor_id NUMBER
)

ALTER TABLE empresa ADD CONSTRAINT fkempresa_setor FOREIGN KEY(setor_id) REFERENCES setor(id)

-- SERVICO_EMPRESA
-- * empresa_id
-- * servico_id

CREATE TABLE servico_empresa (
    empresa_id NUMBER,
    servico_id NUMBER,
    CONSTRAINT pkservico_empresa PRIMARY KEY(empresa_id, servico_id)
)

ALTER TABLE servico_empresa ADD CONSTRAINT fkseremp_empresa FOREIGN KEY(empresa_id) REFERENCES empresa(id)
ALTER TABLE servico_empresa ADD CONSTRAINT fkseremp_servico FOREIGN KEY(servico_id) REFERENCES servico(id)

-- CONTATO
-- * nome
-- * cargo
-- * empresa_id

CREATE SEQUENCE seq_contato

CREATE TABLE contato (
    id NUMBER CONSTRAINT pkcontato PRIMARY KEY,
    nome VARCHAR(255),
    cargo VARCHAR(255),
    empresa_id NUMBER
)

ALTER TABLE contato ADD CONSTRAINT fkcontato_empresa FOREIGN KEY(empresa_id) REFERENCES empresa(id)

-- LIGACAO
-- * dia
-- * efetiva
-- * data_retorno
-- * contato_id
-- * numero
-- * atendida

CREATE SEQUENCE seq_ligacao

CREATE TABLE ligacao (
    id NUMBER CONSTRAINT pkligacao PRIMARY KEY,
    dia DATE,
    efetiva NUMBER,
    data_retorno DATE,
    contato_id NUMBER,
    vendedor_id NUMBER,
    numero NUMBER,
    atendida NUMBER
)

ALTER TABLE ligacao ADD CONSTRAINT fkligacao_contato FOREIGN KEY(contato_id) REFERENCES contato(id)
ALTER TABLE ligacao ADD CONSTRAINT fkligacao_vendedor FOREIGN KEY(vendedor_id) REFERENCES vendedor(id)

-- EMAIL
-- * dia
-- * efetiva
-- * data_retorno
-- * contato_id
-- * destinatario

CREATE SEQUENCE seq_email

CREATE TABLE email (
    id NUMBER CONSTRAINT pkemail PRIMARY KEY,
    dia DATE,
    efetiva NUMBER,
    data_retorno DATE,
    contato_id NUMBER,
    vendedor_id NUMBER,
    destinatario VARCHAR(255)
)

ALTER TABLE email ADD CONSTRAINT fkemail_contato FOREIGN KEY(contato_id) REFERENCES contato(id)
ALTER TABLE email ADD CONSTRAINT fkemail_vendedor FOREIGN KEY(vendedor_id) REFERENCES vendedor(id)

-- REUNIAO
-- * dia
-- * efetiva
-- * data_retorno
-- * contato_id
-- * horario

CREATE SEQUENCE seq_reuniao

CREATE TABLE reuniao (
    id NUMBER CONSTRAINT pkreuniao PRIMARY KEY,
    dia DATE,
    efetiva NUMBER,
    data_retorno DATE,
    contato_id NUMBER,
    vendedor_id NUMBER,
    horario NUMBER
)

ALTER TABLE reuniao ADD CONSTRAINT fkreuniao_contato FOREIGN KEY(contato_id) REFERENCES contato(id)
ALTER TABLE reuniao ADD CONSTRAINT fkreuniao_vendedor FOREIGN KEY(vendedor_id) REFERENCES vendedor(id)
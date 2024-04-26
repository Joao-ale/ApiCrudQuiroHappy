
-- Tabela Prontuario
CREATE TABLE Prontuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    anamnese_id BIGINT,
    cpf VARCHAR(20),
    endereco VARCHAR(255) NOT NULL,
    telefone VARCHAR(20),
    telefoneRespon VARCHAR(20),
    medico_id BIGINT NOT NULL,
    alergia VARCHAR(255),
    queixaDores VARCHAR(255),
    FOREIGN KEY (anamnese_id) REFERENCES Anamnese(id),
    FOREIGN KEY (medico_id) REFERENCES Medico(id)
);
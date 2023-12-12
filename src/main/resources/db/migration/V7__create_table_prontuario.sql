CREATE TABLE Prontuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    anamnese_id INT NOT NULL,
    endereco VARCHAR(255) NOT NULL,
    telefone VARCHAR(255),
    telefoneRespon VARCHAR(255),
    quiropraxista VARCHAR(255) NOT NULL,
    ocupacao VARCHAR(50) NOT NULL,
    alergia VARCHAR(255),
    queixaDores VARCHAR(255),
    FOREIGN KEY (anamnese_id) REFERENCES Anamnese(id)
);

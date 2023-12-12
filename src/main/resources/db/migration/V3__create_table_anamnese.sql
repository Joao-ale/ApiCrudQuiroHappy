CREATE TABLE Anamnese (
    id INT AUTO_INCREMENT PRIMARY KEY,
    paciente_id INT,
    nomeCompleto VARCHAR(255) NOT NULL,
    dataNasc DATE NOT NULL,
    sexo ENUM('Masculino', 'Feminino') NOT NULL,
    ocupacaoProfissional VARCHAR(255),
    atividadeFisica ENUM('Sim', 'Não'),
    peso FLOAT,
    altura FLOAT,
    protese ENUM('Sim', 'Não'),
    internacaoCirurgias ENUM('Sim', 'Não'),
    traumasQuedas ENUM('Sim', 'Não'),
    tabagismo ENUM('Sim', 'Não'),
    etilismo ENUM('Sim', 'Não'),
    qualidadeSono ENUM('Boa', 'Ruim', 'Regular'),
    FOREIGN KEY (paciente_id) REFERENCES Paciente(id)
);

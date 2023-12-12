CREATE TABLE Paciente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    numeroProntuario VARCHAR(255) NOT NULL,
    dataAbertura DATE NOT NULL,
    dataAgendamento DATE NOT NULL,
    dataNascimento DATE NOT NULL,
    sexo ENUM('Masculino', 'Feminino') NOT NULL,
    telefone VARCHAR(13),
    email VARCHAR(255),
    endereco VARCHAR(255),
    medico_id INT,
    especializacao VARCHAR(255),
    limitacao VARCHAR(255),
    FOREIGN KEY (medico_id) REFERENCES Medico(id)
);
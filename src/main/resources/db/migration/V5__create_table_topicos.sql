CREATE TABLE Topicos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    paciente_id INT,
    examImagem VARCHAR(255),
    historicoCond VARCHAR(255),
    tecObs VARCHAR(255),
    FOREIGN KEY (paciente_id) REFERENCES Paciente(id)
);
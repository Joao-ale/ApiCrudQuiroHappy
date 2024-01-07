CREATE TABLE Limitacoes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);

ALTER TABLE prontuario DROP COLUMN limitacoes;


CREATE TABLE prontuario_limitacoes (
    prontuario_id INT,
    limitacao_id INT,
    FOREIGN KEY (prontuario_id) REFERENCES prontuario(id),
    FOREIGN KEY (limitacao_id) REFERENCES limitacoes(id),
    PRIMARY KEY (prontuario_id, limitacao_id)
);


SET @constraint_name = (SELECT CONSTRAINT_NAME
                         FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE
                         WHERE TABLE_NAME = 'prontuario'
                         AND CONSTRAINT_NAME = 'fk_prontuario_limitacoes');

IF @constraint_name IS NOT NULL THEN
    ALTER TABLE prontuario DROP FOREIGN KEY fk_prontuario_limitacoes;
END IF;

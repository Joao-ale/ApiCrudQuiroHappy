package br.com.quiroHappy.ApiCrudQuiroHappy.enums

enum class Errors(val code: String, val message: String) {
    //Prontuario 100 - 150
    QR101("QR-101", "Prontuario [%] não existente"),
    //FichaAnamnese 151 - 200
    QR151("QR-151", "Ficha [%] não existente"),
    //Medico 201 - 250
    QR201("QR-201", "Medico [%] não existente"),
    //Segmentos 251 - 300
    QR251("QR-251", "Segmento [%] não existente"),
    //Doencas 301 - 350
    QR301("QR-301", "Doenca [%] não existente"),
    //Limitacoes 351 - 400
    QR351("QR-351", "Limitacao [%] não existente"),
    //Paciente 401 - 450
    QR401("QR-401", "Paciente [%] não existente")
}
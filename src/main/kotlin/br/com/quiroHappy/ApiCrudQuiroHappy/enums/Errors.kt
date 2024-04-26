package br.com.quiroHappy.ApiCrudQuiroHappy.enums

enum class Errors(val code: String, val message: String) {
    //br.com.quiroHappy.ApiCrudQuiroHappy.model.Prontuario 100 - 150
    QR101("QR-101", "br.com.quiroHappy.ApiCrudQuiroHappy.model.Prontuario [%] não existente"),
    //FichaAnamnese 151 - 200
    QR151("QR-151", "Ficha [%] não existente"),
    //br.com.quiroHappy.ApiCrudQuiroHappy.model.Medico 201 - 250
    QR201("QR-201", "br.com.quiroHappy.ApiCrudQuiroHappy.model.Medico [%] não existente"),
    //br.com.quiroHappy.ApiCrudQuiroHappy.model.Segmentos 251 - 300
    QR251("QR-251", "Segmento [%] não existente"),
    //br.com.quiroHappy.ApiCrudQuiroHappy.model.Doencas 301 - 350
    QR301("QR-301", "Doenca [%] não existente"),
    //br.com.quiroHappy.ApiCrudQuiroHappy.model.Limitacoes 351 - 400
    QR351("QR-351", "Limitacao [%] não existente"),
    //br.com.quiroHappy.ApiCrudQuiroHappy.model.Paciente 401 - 450
    QR401("QR-401", "br.com.quiroHappy.ApiCrudQuiroHappy.model.Paciente [%] não existente"),
    //Ocupacao 451 - 500
    QR451("QR-451", "Ocupacao [%] não existente")
}
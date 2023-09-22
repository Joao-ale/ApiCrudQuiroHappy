package br.com.quiroHappy.ApiCrudQuiroHappy.model

data class Doencas(
    val id: Long,
    val nome: String
) {
    val doencasPredf = listOf<Doencas>(
        Doencas(1,"Hipertensão"),
        Doencas(2,"Diabetes"),
        Doencas(3, "Dislipidemias"),
        Doencas(4,"Renal"),
        Doencas(5, "Hepática"),
        Doencas(6, "Cardiovascular"),
        Doencas(7,"Osteoporose"),
        Doencas(8, "Câncer"),
        Doencas(9, "Respiratória"),
        Doencas(10, "Gênito-Urinaria"),
        Doencas(11, "Gastrointestinal"),
        Doencas(12, "Endócrina"),
        Doencas(13, "De pele"),
        Doencas(14, "Osteomioarticular"),
        Doencas(15, "Neurológica")
    )
}



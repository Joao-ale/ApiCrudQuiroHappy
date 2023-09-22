package br.com.quiroHappy.ApiCrudQuiroHappy.controller.response

data class ErrorResponse (
    val httpCode: Int,
    val message: String,
    val internalCode: String,
    val errors: List<FiledErrorResponse>
){
}
package br.com.quiroHappy.ApiCrudQuiroHappy.exception

class NotFoundException(override val message: String, val errorCode: String):Exception() {
}
package br.com.quiroHappy.ApiCrudQuiroHappy.mapper

interface Mapper<T,U>{
    fun map(t:T):U
}
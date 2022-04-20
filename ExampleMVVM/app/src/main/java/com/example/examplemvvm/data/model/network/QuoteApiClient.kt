package com.example.examplemvvm.data.model.network

import com.example.examplemvvm.data.model.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient { //Realizar llamada rest
    @GET("/.json") //La parte de la api que complementa a base. con ENV en angular.
    suspend fun  getAllQuotes(): Response<List<QuoteModel>> //función suspendida porque usa corrutinas
}
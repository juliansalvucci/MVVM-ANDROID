package com.example.examplemvvm.data.model.network

import com.example.examplemvvm.core.RetrofitHelper
import com.example.examplemvvm.data.model.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class QuoteService @Inject constructor(private val api:QuoteApiClient) {

    suspend fun getQuotes(): List<QuoteModel> { //Función suspendida
        return withContext(Dispatchers.IO) {  //Ejecutar petición en hilo secundario
            val response = api.getAllQuotes()
            response.body() ?: emptyList()
        }
    }
}
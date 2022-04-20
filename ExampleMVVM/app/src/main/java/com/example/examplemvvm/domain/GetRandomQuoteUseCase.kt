package com.example.examplemvvm.domain

import com.example.examplemvvm.data.model.QuoteRepository
import com.example.examplemvvm.data.model.model.QuoteModel
import com.example.examplemvvm.data.model.model.QuoteProvider
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val quoteProvider: QuoteProvider){  //caso de uso para devolver cita random

    operator fun invoke():QuoteModel?{
        val quotes = quoteProvider.quotes
        if (!quotes.isNullOrEmpty()){ //Se fija si el listado de citas no es nulo
            val randomNumber = (quotes.indices).random() //Si hay citas, toma una aleatoria de la lista.
            return quotes[randomNumber] //devuelve una sola cita.
        }
        return null
    }
}
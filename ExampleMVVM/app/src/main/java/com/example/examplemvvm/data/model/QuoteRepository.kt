package com.example.examplemvvm.data.model

import com.example.examplemvvm.data.model.model.QuoteModel
import com.example.examplemvvm.data.model.model.QuoteProvider
import com.example.examplemvvm.data.model.network.QuoteService
import javax.inject.Inject
import kotlin.text.Typography.quote

class QuoteRepository @Inject constructor(private val api:QuoteService , private val quoteProvider: QuoteProvider){

    suspend fun getAllQuotes():List<QuoteModel>{
        val response: List<QuoteModel> = api.getQuotes()
        quoteProvider.quotes = response
        return response
    }
}
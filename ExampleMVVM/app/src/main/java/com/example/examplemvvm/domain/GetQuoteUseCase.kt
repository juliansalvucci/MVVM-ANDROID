package com.example.examplemvvm.domain

import com.example.examplemvvm.data.model.QuoteRepository
import com.example.examplemvvm.data.model.model.QuoteModel
import javax.inject.Inject

class GetQuoteUseCase @Inject constructor(private val repository: QuoteRepository){

    suspend operator fun invoke():List<QuoteModel>? = repository.getAllQuotes()

}
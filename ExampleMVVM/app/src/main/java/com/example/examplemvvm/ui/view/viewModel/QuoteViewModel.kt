package com.example.examplemvvm.ui.view.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examplemvvm.data.model.QuoteRepository
import com.example.examplemvvm.data.model.model.QuoteModel
import com.example.examplemvvm.data.model.model.QuoteProvider
import com.example.examplemvvm.domain.GetQuoteUseCase
import com.example.examplemvvm.domain.GetRandomQuoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel  @Inject constructor(
    private val getQuoteUseCase: GetQuoteUseCase,
    private val getRandomQuoteUseCase: GetRandomQuoteUseCase
): ViewModel() {
    val quoteModel = MutableLiveData<QuoteModel?>() //Esto le avisa al activity que hubo cambios.
    val isLoading = MutableLiveData<Boolean>() //boolean para progressbar

    fun onCreate(){
        viewModelScope.launch {  //permite controlar la corrutina automáticamente.

            isLoading.postValue(true)

            val result  = getQuoteUseCase()  //el CU llama al repo luego repo ve de donde saca la info y el servicio llama a la api por retrofit.

            if (!result.isNullOrEmpty()){
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }

    }

    fun randomQuote(){
        isLoading.postValue(true)

        val quote = getRandomQuoteUseCase()
        if(quote!=null){
            quoteModel.postValue(quote) //Si se obtiene un regostro, que se asigne al modelo.
        }
        isLoading.postValue(false)
    }


}
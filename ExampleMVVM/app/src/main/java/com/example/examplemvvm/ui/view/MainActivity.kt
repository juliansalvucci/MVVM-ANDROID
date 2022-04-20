package com.example.examplemvvm.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.examplemvvm.R
import com.example.examplemvvm.databinding.ActivityMainBinding
import com.example.examplemvvm.ui.view.viewModel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint //dejo la clase preparada para inyectarse.
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding //Iniciar el binding.

    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        quoteViewModel.onCreate()

        quoteViewModel.quoteModel.observe(this, Observer {
            binding.tvQuote.text = it?.quote
            binding.tvAuthor.text = it?.author
        })

        quoteViewModel.isLoading.observe(this, Observer {  //Configuración progress bar
            binding.loading.isVisible = it
        })

        binding.viewContainer.setOnClickListener{quoteViewModel.randomQuote()}
    }
}
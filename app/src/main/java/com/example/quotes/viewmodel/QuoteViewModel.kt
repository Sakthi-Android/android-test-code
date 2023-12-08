package com.example.quotes.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quotes.data.model.Quotes
import com.example.quotes.repository.QuotesRepository
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel() {
    private val repository = QuotesRepository()

    val quotesCardsLiveData = MutableLiveData(listOf<Quotes>())

    val quotesCards: LiveData<List<Quotes>> = quotesCardsLiveData

    fun fetchQuotes() {
        viewModelScope.launch {
            try {
                val quotes = repository.getQuotes()
                quotesCardsLiveData.value = listOf(quotes)
            } catch (e: Exception) {
                // Handle error
                Log.e("Error", e.message.toString())
            }
        }
    }
}
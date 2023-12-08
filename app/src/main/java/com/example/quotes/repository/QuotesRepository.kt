package com.example.quotes.repository

import com.example.quotes.data.model.Quotes
import com.example.quotes.service.RetrofitInstance

class QuotesRepository {
    private val quotesService = RetrofitInstance.quotesDataService

    suspend fun getQuotes(): Quotes {
        return quotesService.getQuotesData()
    }
}
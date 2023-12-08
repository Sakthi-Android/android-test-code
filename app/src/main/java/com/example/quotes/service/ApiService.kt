package com.example.quotes.service

import com.example.quotes.data.model.Quotes
import retrofit2.http.GET

interface ApiService {

        @GET("/quotes")
        suspend fun getQuotesData(): Quotes
}
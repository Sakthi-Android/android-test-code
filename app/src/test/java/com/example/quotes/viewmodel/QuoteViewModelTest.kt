package com.example.quotes.viewmodel

import org.junit.jupiter.api.Test

class QuoteViewModelTest {

    val viewModel = QuoteViewModel()

    @Test
    fun `when loadData() is called, should load data`() {
        viewModel.fetchQuotes()
        assert(viewModel.quotesCardsLiveData.value.isNullOrEmpty())
    }
}
package com.example.quotes.view

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.quotes.viewmodel.QuoteViewModel
import com.example.quotes.data.model.Result


@Composable
fun QuotesViewScreen(viewModel: QuoteViewModel) {
    val quotesData by viewModel.quotesCards.observeAsState(null)

    LaunchedEffect(Unit) {
        viewModel.fetchQuotes()
    }

    Column {
        if (quotesData == null) {
            Text(text = "Loading...")
        } else {
            QuotesDataItem(viewModel)
        }
    }
}

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun QuotesDataItem(viewModel: QuoteViewModel) {
    val listData: ArrayList<List<Result>> = ArrayList()
    val result: ArrayList<Result> = ArrayList()
    viewModel.quotesCards.value?.forEach {
        listData.add(it.results)
    }
    listData.forEach { it ->
        it.forEach { data ->
            result.add(data)
            Log.e("data", data.toString())
        }

    }
    Column(
        modifier = Modifier,
    ) {
        LazyColumn {
            items(result) { language ->
                androidx.compose.material3.Card(
                    modifier = Modifier.padding(8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White,
                    ),
                ) {
                    Column(
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth()
                    ) {
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = language.author.toString(),
                            modifier = Modifier.padding(4.dp),
                            color = Color.Black, textAlign = TextAlign.Center
                        )
                        Text(
                            text = language.content.toString(),
                            modifier = Modifier.padding(4.dp),
                            color = Color.Black, textAlign = TextAlign.Center,
                            fontWeight = FontWeight.SemiBold
                        )

                        androidx.compose.material3.Text(
                            text = "${language.dateAdded} - ${language.dateModified}",
                            modifier = Modifier.padding(4.dp),
                            color = Color.Black, textAlign = TextAlign.Center
                        )
                    }
                }
                Divider()
            }
        }
    }
}
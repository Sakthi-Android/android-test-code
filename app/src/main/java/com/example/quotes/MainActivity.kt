package com.example.quotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quotes.ui.theme.HTTPStatusDogsTheme
import com.example.quotes.view.QuotesViewScreen
import com.example.quotes.viewmodel.QuoteViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: QuoteViewModel by viewModels()

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HTTPStatusDogsTheme {
                Column {
                    TopAppBar(
                        modifier = Modifier.background(Color.White),
                        title = {
                            Text(
                                text = "Quotes",
                                style = MaterialTheme.typography.titleLarge,
                                fontSize = 22.sp,
                                fontWeight = FontWeight.SemiBold
                            )

                        }
                    )
                    androidx.compose.material.Divider()
                    Spacer(modifier = Modifier.height(2.dp))
                    QuotesViewScreen(viewModel)
                }
            }
        }
    }
}

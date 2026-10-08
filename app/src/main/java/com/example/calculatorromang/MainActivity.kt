package com.example.calculatorromang

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculatorromang.ui.theme.CalculatorRomanGTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorRomanGTheme {
                TipCalculatorScreen()
            }
        }
    }
}

@Composable
fun TipCalculatorScreen() {

    var SummaZacaz by remember { mutableStateOf("") }
    var ColVoBlyd by remember { mutableStateOf("") }
    var ProcTea by remember { mutableStateOf(0f) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = TODO(),
        content = TODO()
    )

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalculatorRomanGTheme {
        TipCalculatorScreen()
    }
}
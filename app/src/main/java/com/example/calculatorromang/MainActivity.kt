package com.example.calculatorromang

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

fun calculateScidca(blyd: Int): Int {
    return when {
        blyd in 1..2 -> 3
        blyd in 3..5 -> 5
        blyd in 6..10 -> 7
        blyd > 10 -> 10
        else -> 0
    }
}

@Composable
fun TipCalculatorScreen() {

    var SummaZacaz by remember { mutableStateOf("") }
    var ColVoBlyd by remember { mutableStateOf("") }
    var ProcTea by remember { mutableStateOf(0f) }

    val scidca = calculateScidca(
        ColVoBlyd.toIntOrNull() ?: 0
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Top
    ) {

        Text(
            text = "Сумма заказа",
            fontSize = 18.sp
        )

        OutlinedTextField(
            value = SummaZacaz,
            onValueChange = {
                SummaZacaz = it
            },
            label = {
                Text("Сумма заказа")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Text(
            text = "Количество блюд",
            fontSize = 18.sp
        )

        OutlinedTextField(
            value = ColVoBlyd,
            onValueChange = {
                ColVoBlyd = it
            },
            label = {
                Text("Количество блюд")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(32.dp)
        )

        Text(
            text = "Чаевые:",
            fontSize = 18.sp
        )

        Slider(
            value = ProcTea,
            onValueChange = {
                ProcTea = it
            },
            valueRange = 0f..25f,
            modifier = Modifier.fillMaxWidth()
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("0")
            Text("25")
        }

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Text(
            text = "Скидка:",
            fontSize = 22.sp
        )

        ScidcaRadioButtons(scidca)
    }
}

@Composable
fun ScidcaRadioButtons(scidca: Int) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RadioButton(
                selected = scidca == 3,
                onClick = null
            )

            Text("3%")
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RadioButton(
                selected = scidca == 5,
                onClick = null
            )

            Text("5%")
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RadioButton(
                selected = scidca == 7,
                onClick = null
            )

            Text("7%")
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RadioButton(
                selected = scidca == 10,
                onClick = null
            )

            Text("10%")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalculatorRomanGTheme {
        TipCalculatorScreen()
    }
}
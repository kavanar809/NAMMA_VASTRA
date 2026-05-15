package com.example.namma_vastra.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.namma_vastra.model.orZero

@Composable
fun CalculatorScreen() {

    var materialCost by remember {
        mutableStateOf("")
    }

    var laborCost by remember {
        mutableStateOf("")
    }

    var otherCost by remember {
        mutableStateOf("")
    }

    var result by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF8F0))
            .padding(16.dp)
    ) {

        Text(
            text = "Price Calculator",
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = materialCost,
            onValueChange = {
                materialCost = it
            },
            label = {
                Text("Material Cost")
            }
        )

        Spacer(modifier = Modifier.height(12.dp))

        TextField(
            value = laborCost,
            onValueChange = {
                laborCost = it
            },
            label = {
                Text("Labor Cost")
            }
        )

        Spacer(modifier = Modifier.height(12.dp))

        TextField(
            value = otherCost,
            onValueChange = {
                otherCost = it
            },
            label = {
                Text("Other Cost")
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {

                val total =
                    materialCost.toIntOrNull().orZero() +
                            laborCost.toIntOrNull().orZero() +
                            otherCost.toIntOrNull().orZero()

                result = "₹$total"
            },
            modifier = Modifier.fillMaxWidth()
        ) {

            Text("Calculate Price")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Suggested Price: $result",
            fontSize = 20.sp
        )
    }
}
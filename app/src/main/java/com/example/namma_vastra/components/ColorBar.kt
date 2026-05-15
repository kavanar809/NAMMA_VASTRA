package com.example.namma_vastra.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ColorBar(name: String, color: Color) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(24.dp)
            .background(color)
    ) {

        Text(
            text = name,
            modifier = Modifier.padding(start = 8.dp, top = 2.dp),
            fontSize = 10.sp
        )
    }
}
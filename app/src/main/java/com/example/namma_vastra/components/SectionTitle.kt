package com.example.namma_vastra.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SectionTitle(title: String) {

    Text(
        text = title,
        color = Color.White,
        fontSize = 14.sp
    )

    Spacer(modifier = Modifier.height(12.dp))
}
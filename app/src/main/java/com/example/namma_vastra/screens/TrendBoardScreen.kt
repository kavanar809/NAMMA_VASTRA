package com.example.namma_vastra.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.namma_vastra.components.ColorBar
import com.example.namma_vastra.R
import com.example.namma_vastra.components.SectionTitle
import com.example.namma_vastra.components.SuggestionCard
import com.example.namma_vastra.components.TrendCard
import com.example.namma_vastra.components.TrendImage
import com.example.namma_vastra.components.ColorBar
import com.example.namma_vastra.components.SectionTitle
import com.example.namma_vastra.components.TrendCard

@Composable
fun TrendBoardScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF062020))
            .verticalScroll(rememberScrollState())
            .padding(16.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "LATEST MARKET\nTRENDS FOR\nHANDLOOM SAREES",
            color = Color.White,
            fontSize = 22.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Trending Colors
        SectionTitle("TRENDING COLORS")

        TrendCard {

            ColorBar("PISTACHIO", Color(0xFFBFD8B8))
            ColorBar("CHOCOLATE ICE CREAM", Color(0xFF8B5A2B))
            ColorBar("LAVENDER INDIGO", Color(0xFF7B68EE))
            ColorBar("SPRING TEAL", Color(0xFF008080))
            ColorBar("LOVE POTION", Color(0xFFC71585))
            ColorBar("CANARY YELLOW", Color(0xFFFFEF00))
            ColorBar("WARM PASTEL BROWN", Color(0xFFB5651D))
            ColorBar("PASTEL LIGHT LAVENDER", Color(0xFFE6E6FA))
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Trending Sarees
        SectionTitle("TRENDING SAREES")

        TrendCard {

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {

                TrendImage(R.drawable.trend1)
                TrendImage(R.drawable.trend2)
                TrendImage(R.drawable.trend3)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Trending Patterns
        SectionTitle("TRENDING PATTERNS")

        TrendCard {

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {

                TrendImage(R.drawable.pattern1)
                TrendImage(R.drawable.pattern2)
                TrendImage(R.drawable.pattern3)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // AI Suggestions
        SectionTitle("AI SUGGESTION")

        SuggestionCard("PASTEL SHADES LIKE LAVENDER AND PINK ARE IN HIGH DEMAND")

        Spacer(modifier = Modifier.height(12.dp))

        SuggestionCard("LIGHTWEIGHT SILK SAREES SELL FASTER IN URBAN MARKET")

        Spacer(modifier = Modifier.height(12.dp))

        SuggestionCard("MINIMAL BORDERS WITH CONTRAST PALLU ARE TRENDING")

        Spacer(modifier = Modifier.height(40.dp))
    }
}
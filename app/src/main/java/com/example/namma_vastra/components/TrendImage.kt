package com.example.namma_vastra.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun TrendImage(image: Int) {

    Image(
        painter = painterResource(id = image),
        contentDescription = null,
        modifier = Modifier
            .size(80.dp)
            .clip(RoundedCornerShape(40.dp)),

        contentScale = ContentScale.Crop
    )
}
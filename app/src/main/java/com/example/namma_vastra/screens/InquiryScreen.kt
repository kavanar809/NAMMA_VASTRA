package com.example.namma_vastra.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InquiryScreen(

    name: String,
    price: String,
    material: String,
    weaverName: String,
    weaverPhone: String,
    location: String

) {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5EFE6))
            .padding(24.dp),

        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = name,
            fontSize = 28.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Price: ₹$price",
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Material: $material",
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Weaver: $weaverName",
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Location: $location",
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Contact: $weaverPhone",
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {

                val message = """
Hello $weaverName,

I am interested in your saree.

Name: $name
Material: $material
Price: ₹$price

Please share more details.
                """.trimIndent()

                val url =
                    "https://wa.me/$weaverPhone?text=${Uri.encode(message)}"

                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(url)
                )

                context.startActivity(intent)
            },
            modifier = Modifier.fillMaxWidth()
        ) {

            Text("Send via WhatsApp")
        }
    }
}
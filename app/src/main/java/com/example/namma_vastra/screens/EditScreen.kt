package com.example.namma_vastra.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun EditScreen(
    sareeId: String
) {

    val context = LocalContext.current

    val db = FirebaseFirestore.getInstance()

    var name by remember {
        mutableStateOf("")
    }

    var price by remember {
        mutableStateOf("")
    }

    var material by remember {
        mutableStateOf("")
    }

    var category by remember {
        mutableStateOf("")
    }
    var weaverName by remember {
        mutableStateOf("")
    }

    var weaverPhone by remember {
        mutableStateOf("")
    }

    var location by remember {
        mutableStateOf("")
    }

    LaunchedEffect(Unit) {

        db.collection("sarees")
            .document(sareeId)
            .get()
            .addOnSuccessListener { document ->

                name = document.getString("name") ?: ""

                price = document.getString("price") ?: ""

                material = document.getString("material") ?: ""

                category = document.getString("category") ?: ""
                weaverName =
                    document.getString("weaverName") ?: ""

                weaverPhone =
                    document.getString("weaverPhone") ?: ""

                location =
                    document.getString("location") ?: ""
            }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5EFE6))
            .padding(20.dp)
            .verticalScroll(rememberScrollState()),

        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Edit Saree",
            fontSize = 28.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = name,
            onValueChange = {
                name = it
            },
            label = {
                Text("Saree Name")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        TextField(
            value = price,
            onValueChange = {
                price = it
            },
            label = {
                Text("Price")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        TextField(
            value = material,
            onValueChange = {
                material = it
            },
            label = {
                Text("Material")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        TextField(
            value = category,
            onValueChange = {
                category = it
            },
            label = {
                Text("Category")
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(12.dp))

        TextField(
            value = weaverName,
            onValueChange = {
                weaverName = it
            },
            label = {
                Text("Weaver Name")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        TextField(
            value = weaverPhone,
            onValueChange = {
                weaverPhone = it
            },
            label = {
                Text("Phone Number")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        TextField(
            value = location,
            onValueChange = {
                location = it
            },
            label = {
                Text("Location")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {

                val updates = hashMapOf<String, Any>(
                    "name" to name,
                    "price" to price,
                    "material" to material,
                    "category" to category,
                    "weaverName" to weaverName,
                    "weaverPhone" to weaverPhone,
                    "location" to location
                )

                db.collection("sarees")
                    .document(sareeId)
                    .update(updates)
                    .addOnSuccessListener {

                        Toast.makeText(
                            context,
                            "Updated Successfully",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
            },
            modifier = Modifier.fillMaxWidth()
        ) {

            Text("Save Changes")
        }
    }
}


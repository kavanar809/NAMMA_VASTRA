package com.example.namma_vastra.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.namma_vastra.model.Saree
import com.example.namma_vastra.components.SareeCard
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun GalleryScreen(
    navController: NavHostController,
    isWeaver: Boolean
){

    val db = FirebaseFirestore.getInstance()

    val sareeList = remember {
        mutableStateListOf<Saree>()
    }

    LaunchedEffect(true) {

        db.collection("sarees")
            .get()
            .addOnSuccessListener { result ->

                sareeList.clear()

                for (document in result) {

                    val saree =
                        document.toObject(Saree::class.java)
                            .copy(id = document.id)

                    sareeList.add(saree)
                }
            }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF8F0))
            .padding(16.dp)
    ) {

        item {

            Text(
                text = "Loom Gallery",
                fontSize = 24.sp
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )
        }

        items(sareeList) { saree ->

            SareeCard(
                saree = saree,
                navController = navController,
                isWeaver = isWeaver
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )
        }
    }
}
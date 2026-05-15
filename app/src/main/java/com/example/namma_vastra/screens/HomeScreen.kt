package com.example.namma_vastra.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.namma_vastra.R
import com.example.namma_vastra.components.HomeButton
import com.google.firebase.auth.FirebaseAuth
@Composable
fun HomeScreen(
    navController: NavHostController,
    isWeaver: Boolean
) {

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.loom_bg),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0x66000000))
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),

            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "NAMMA VASTRA",
                color = Color.White,
                fontSize = 26.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "CONNECTING WEAVERS TO MARKET",
                color = Color.White,
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(40.dp))

            HomeButton("Trend Board") {
                navController.navigate("trend")
            }

            Spacer(modifier = Modifier.height(16.dp))

            HomeButton("Loom Gallery") {
                if (isWeaver) {

                    navController.navigate("weaver_gallery")

                } else {

                    navController.navigate("gallery")
                }}

            Spacer(modifier = Modifier.height(16.dp))

            if (isWeaver) {

                HomeButton("Upload Saree") {
                    navController.navigate("upload")
                }

                Spacer(modifier = Modifier.height(16.dp))

                HomeButton("Price Calculator") {
                    navController.navigate("calculator")
                }
                Spacer(modifier = Modifier.height(16.dp))

                HomeButton(
                    text = "Logout",
                    onClick = {

                        FirebaseAuth
                            .getInstance()
                            .signOut()

                        navController.navigate("role") {

                            popUpTo(0)
                        }
                    }
                )
            }
        }
    }
}
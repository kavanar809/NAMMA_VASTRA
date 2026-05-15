package com.example.namma_vastra.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.firebase.auth.FirebaseAuth

@Composable
fun LoginScreen(
    navController: NavHostController
) {

    val context = LocalContext.current

    val auth = FirebaseAuth.getInstance()

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5EFE6))
            .padding(20.dp),

        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Weaver Login",
            fontSize = 28.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        TextField(
            value = email,
            onValueChange = {
                email = it
            },
            label = {
                Text("Email")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        TextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = {
                Text("Password")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {

                auth.signInWithEmailAndPassword(
                    email,
                    password
                ).addOnSuccessListener {

                    Toast.makeText(
                        context,
                        "Login Successful",
                        Toast.LENGTH_SHORT
                    ).show()

                    navController.navigate(
                        "weaver_home"
                    )
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {

            Text("Login")
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {

                navController.navigate(
                    "register"
                )

            },
            modifier = Modifier.fillMaxWidth()
        ) {

            Text("Create New Account")
        }
    }
}
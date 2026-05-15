package com.example.namma_vastra.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import androidx.navigation.NavHostController
import com.example.namma_vastra.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun RegisterScreen(
    navController: NavHostController
) {

    val context = LocalContext.current

    val auth = FirebaseAuth.getInstance()

    val db = FirebaseFirestore.getInstance()

    var name by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var phone by remember {
        mutableStateOf("")
    }

    var location by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5EFE6))
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
    ) {

        Text(
            text = "Weaver Registration",
            fontSize = 28.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        TextField(
            value = name,
            onValueChange = {
                name = it
            },
            label = {
                Text("Name")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

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

        Spacer(modifier = Modifier.height(12.dp))

        TextField(
            value = phone,
            onValueChange = {
                phone = it
            },
            label = {
                Text("Phone")
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

                if (
                    name.isBlank() ||
                    email.isBlank() ||
                    password.isBlank()
                ) {

                    Toast.makeText(
                        context,
                        "Please fill all fields",
                        Toast.LENGTH_SHORT
                    ).show()

                    return@Button
                }

                auth.createUserWithEmailAndPassword(
                    email,
                    password
                )

                    .addOnSuccessListener {

                        val uid =
                            auth.currentUser?.uid ?: ""

                        val user = User(
                            uid = uid,
                            name = name,
                            email = email,
                            phone = phone,
                            location = location,
                            role = "weaver"
                        )

                        db.collection("users")
                            .document(uid)
                            .set(user)

                            .addOnSuccessListener {

                                Toast.makeText(
                                    context,
                                    "Registration Successful",
                                    Toast.LENGTH_SHORT
                                ).show()

                                navController.navigate(
                                    "weaver_home"
                                )
                            }
                    }

                    .addOnFailureListener {

                        Toast.makeText(
                            context,
                            it.message ?: "Registration Failed",
                            Toast.LENGTH_LONG
                        ).show()
                    }
            },

            modifier = Modifier.fillMaxWidth()
        ) {

            Text("Register")
        }
    }
}
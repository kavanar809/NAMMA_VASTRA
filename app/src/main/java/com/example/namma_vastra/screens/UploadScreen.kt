package com.example.namma_vastra.screens

//import androidx.compose.foundation.lazy.LazyRow
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.namma_vastra.model.Saree
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import java.util.UUID


@Composable
fun UploadScreen() {

    val context = LocalContext.current

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

    var imageUri by remember {
        mutableStateOf<Uri?>(null)
    }

    val categories = listOf(
        "Ilkal",
        "Kanchivaram",
        "Mysore Silk",
        "Handloom Cotton",
        "Casual",
        "Festival",
        "Designer"
    )

    val db = FirebaseFirestore.getInstance()

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->

        imageUri = uri
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF062020))
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {

        Text(
            text = "Upload Saree",
            fontSize = 24.sp,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(20.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(24.dp))
                .background(Color(0xFFF3EEDD))
                .padding(20.dp)

        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.LightGray)
                    .clickable {
                        launcher.launch("image/*")
                    },

                contentAlignment = Alignment.Center
            ) {

                if (imageUri != null) {

                    Image(
                        painter = rememberAsyncImagePainter(imageUri),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )

                } else {

                    Text("Tap to upload image")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

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

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Category",
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            LazyRow {

                items(categories) { item ->

                    Button(
                        onClick = {
                            category = item
                        },
                        modifier = Modifier.padding(end = 8.dp)
                    ) {

                        Text(item)
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {

                    if (
                        name.isNotEmpty() &&
                        price.isNotEmpty() &&
                        material.isNotEmpty() &&
                        weaverName.isNotEmpty() &&
                        weaverPhone.isNotEmpty() &&
                        location.isNotEmpty() &&
                        imageUri != null
                    ) {

                        val storageRef = FirebaseStorage
                            .getInstance()
                            .reference
                            .child(
                                "saree_images/${UUID.randomUUID()}"
                            )

                        storageRef.putFile(imageUri!!)
                            .addOnSuccessListener {

                                storageRef.downloadUrl
                                    .addOnSuccessListener { downloadUrl ->

                                        val saree = Saree(
                                            ownerId = FirebaseAuth
                                                .getInstance()
                                                .currentUser
                                                ?.uid ?: "",
                                            name = name,
                                            price = price,
                                            material = material,
                                            category = category,
                                            weaverName = weaverName,
                                            weaverPhone = weaverPhone,
                                            location = location,
                                            imageUri = downloadUrl.toString(),
                                            imageRes = 0
                                        )

                                        db.collection("sarees")
                                            .add(saree)
                                            .addOnSuccessListener {

                                                Toast.makeText(
                                                    context,
                                                    "Saree uploaded successfully",
                                                    Toast.LENGTH_SHORT
                                                ).show()

                                                name = ""
                                                price = ""
                                                material = ""
                                                category = ""
                                                weaverName = ""
                                                weaverPhone = ""
                                                location = ""
                                                imageUri = null
                                            }
                                    }
                            }

                    } else {

                        Toast.makeText(
                            context,
                            "Please fill all fields",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {

                Text("Upload Saree")
            }
        }
    }
}
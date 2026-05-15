package com.example.namma_vastra.components

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.namma_vastra.R
import com.example.namma_vastra.model.Saree
import com.google.firebase.firestore.FirebaseFirestore
import com.example.namma_vastra.components.SareeCard
import com.google.firebase.auth.FirebaseAuth
@Composable
fun SareeCard(
    saree: Saree,
    navController: NavHostController,
    isWeaver: Boolean
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),

        shape = RoundedCornerShape(24.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            if (saree.imageUri.isNotEmpty()) {

                Image(
                    painter = rememberAsyncImagePainter(saree.imageUri),
                    contentDescription = saree.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp),
                    contentScale = ContentScale.Crop
                )

            } else {

                Image(
                    painter = painterResource(
                        id =
                            if (saree.imageRes != 0)
                                saree.imageRes
                            else
                                R.drawable.saree1
                    ),
                    contentDescription = saree.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
            Spacer(modifier = Modifier.height(12.dp))

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(50.dp))
                    .background(Color(0xFF0D3B3B))
                    .padding(horizontal = 12.dp, vertical = 4.dp)
            ) {

                Text(
                    text = "TRENDING",
                    color = Color.White,
                    fontSize = 12.sp
                )
            }
            Text(
                text = saree.name,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "₹${saree.price}",
                fontSize = 20.sp,
                color = Color(0xFF0D3B3B)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Material: ${saree.material}",
                fontSize = 14.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(

                onClick = {
                    navController.navigate(
                        "inquiry/" +
                                "${saree.name}/" +
                                "${saree.price}/" +
                                "${saree.material}/" +
                                "${saree.weaverName}/" +
                                "${saree.weaverPhone}/" +
                                "${saree.location}"
                    )
                },
                modifier = Modifier.fillMaxWidth()

            ) {

                Text("Inquire")
            }
            Spacer(modifier = Modifier.height(8.dp))

            if (
                isWeaver &&
                saree.ownerId ==
                FirebaseAuth.getInstance()
                    .currentUser
                    ?.uid
            ) {

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = {

                        FirebaseFirestore.getInstance()
                            .collection("sarees")
                            .document(saree.id)
                            .delete()

                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Delete")
                }
                if (
                    isWeaver &&
                    saree.ownerId ==
                    FirebaseAuth.getInstance()
                        .currentUser
                        ?.uid
                ) {

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(
                        onClick = {

                            navController.navigate(
                                "edit/${saree.id}"
                            )

                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        Text("Edit")
                    }
                }
            }}
    }}
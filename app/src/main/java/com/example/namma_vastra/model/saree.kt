package com.example.namma_vastra.model

import com.example.namma_vastra.R

data class Saree(

    val id: String = "",

    val name: String = "",

    val price: String = "",

    val material: String = "",

    val category: String = "",

    val weaverName: String = "",

    val weaverPhone: String = "",

    val location: String = "",

    val imageUri: String = "",

    val imageRes: Int = R.drawable.saree1,
    val ownerId: String = ""
)

fun Int?.orZero(): Int {

    return this ?: 0
}
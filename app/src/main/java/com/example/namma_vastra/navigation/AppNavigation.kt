package com.example.namma_vastra.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.namma_vastra.screens.*

@Composable
fun AppNavigation() {

    val navController = rememberNavController()
    val currentUser =
        com.google.firebase.auth.FirebaseAuth
            .getInstance()
            .currentUser

    val startDestination =

        if (currentUser != null) {

            "weaver_home"

        } else {

            "role"
        }
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {

        composable("role") {

            RoleSelectionScreen(navController)
        }

        composable("buyer_home") {

            HomeScreen(
                navController = navController,
                isWeaver = false
            )
        }

        composable("weaver_home") {

            HomeScreen(
                navController = navController,
                isWeaver = true
            )
        }

        composable("trend") {

            TrendBoardScreen()
        }

        composable("gallery") {

            GalleryScreen(
                navController = navController,
                isWeaver = false
            )
        }
        composable("weaver_gallery") {

            GalleryScreen(
                navController = navController,
                isWeaver = true
            )
        }

        composable("upload") {

            UploadScreen()
        }

        composable("calculator") {

            CalculatorScreen()
        }
        composable(
            "edit/{sareeId}"
        ) { backStackEntry ->

            EditScreen(

                sareeId = backStackEntry.arguments
                    ?.getString("sareeId") ?: ""
            )
        }
        composable("register") {

            RegisterScreen(navController)
        }
        composable("login") {

            LoginScreen(navController)
        }
        composable(
            "inquiry/{name}/{price}/{material}/{weaverName}/{weaverPhone}/{location}"
        ) { backStackEntry ->

            InquiryScreen(
                name = backStackEntry.arguments
                    ?.getString("name") ?: "",

                price = backStackEntry.arguments
                    ?.getString("price") ?: "",

                material = backStackEntry.arguments
                    ?.getString("material") ?: "",
                weaverName = backStackEntry.arguments
                    ?.getString("weaverName") ?: "",

                weaverPhone = backStackEntry.arguments
                    ?.getString("weaverPhone") ?: "",

                location = backStackEntry.arguments
                    ?.getString("location") ?: ""
            )
        }
    }
}
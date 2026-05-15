package com.example.namma_vastra

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.namma_vastra.navigation.AppNavigation
import com.example.namma_vastra.ui.theme.NAMMA_VASTRATheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            NAMMA_VASTRATheme {

                AppNavigation()
            }
        }
    }
}
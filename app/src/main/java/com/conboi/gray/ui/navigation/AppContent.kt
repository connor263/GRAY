package com.conboi.gray.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.conboi.gray.MainViewModel

@Composable
fun AppContent(viewModel: MainViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "init") {
        composable("init") {
            Surface(modifier = Modifier.fillMaxSize(), color = Color.Black) {
                Box(modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .size(120.dp)
                            .align(Alignment.Center),
                        color = Color.White
                    )
                }
            }
        }
    }

    LaunchedEffect(viewModel.route) {
        if (viewModel.route.isNotBlank()) {
            navController.navigate(viewModel.route) {
                popUpTo("init") { inclusive = true }
            }
        }
    }
}
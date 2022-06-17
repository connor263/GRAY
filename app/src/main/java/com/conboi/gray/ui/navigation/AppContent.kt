package com.conboi.gray.ui.navigation

import android.content.Intent
import android.net.Uri
import android.net.http.SslError
import android.view.ViewGroup
import android.webkit.*
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.conboi.gray.MainViewModel
import com.conboi.gray.ui.web.WebScreen
import kotlin.random.Random

@Composable
fun AppContent(viewModel: MainViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "init") {
        composable("init") {
            Surface(modifier = Modifier.fillMaxSize(), color = Color.Black) {
                Column(modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(
                        modifier = Modifier.fillMaxSize().size(120.dp),
                        color = Color.White
                    )
                }
            }
        }
        composable("web/{link}", listOf(navArgument("link") {
            type = NavType.StringType
        })) {
            it.arguments?.getString("link")?.let { link ->
                WebScreen(navController,link)
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
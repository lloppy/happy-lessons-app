package com.lloppy.hapson

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.lloppy.hapson.navigation.SetupNavGraph
import com.lloppy.hapson.navigation.createExternalRouter
import com.lloppy.hapson.navigation.navigate
import com.lloppy.hapson.ui.theme.HapsonTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HapsonTheme {
                navController = rememberNavController()

                SetupNavGraph(
                    navController,
                    context = this@MainActivity,
                    lifecycleScope = lifecycleScope,
                    lifecycleOwner = this@MainActivity,
                    router = createExternalRouter { screen, params ->
                        navController.navigate(screen, params)
                    }
                )
            }
        }
    }
}

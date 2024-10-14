package com.noureldin.githubrepositoryodcamit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.noureldin.githubrepositoryodcamit.presentation.navigation.AppNavHost
import com.noureldin.githubrepositoryodcamit.presentation.theme.GitHubRepositoryODCAMITTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GitHubRepositoryODCAMITTheme {
               AppNavHost()
            }
        }
    }
}

@Preview(showBackground = true,showSystemUi = true)
@Composable
fun GreetingPreview() {
    GitHubRepositoryODCAMITTheme {
        AppNavHost()
    }
}
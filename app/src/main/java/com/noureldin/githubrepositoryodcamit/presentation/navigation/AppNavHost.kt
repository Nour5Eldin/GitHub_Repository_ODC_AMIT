package com.noureldin.githubrepositoryodcamit.presentation.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.noureldin.githubrepositoryodcamit.presentation.screens.repo_details_screen.RepoDetailsScreen
import com.noureldin.githubrepositoryodcamit.presentation.screens.repo_isuues_screen.IssuesScreen
import com.noureldin.githubrepositoryodcamit.presentation.screens.repo_isuues_screen.component.IssuesUiState
import com.noureldin.githubrepositoryodcamit.presentation.screens.repo_isuues_screen.preview_data.issuesUiModelPreviewData
import com.noureldin.githubrepositoryodcamit.presentation.screens.repo_list_screen.RepoListScreen
import com.noureldin.githubrepositoryodcamit.presentation.utils.Constant.Companion.NAME_ARGUMENT_KEY
import com.noureldin.githubrepositoryodcamit.presentation.utils.Constant.Companion.OWNER_ARGUMENT_KEY

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(navController= navController,
        startDestination = Screens.RepoListScreen.route) {
        composable(route= Screens.RepoListScreen.route){
            RepoListScreen{ ownerName, name ->
                navController.navigate(Screens.RepoDetailsScreen.passOwnerAndName(ownerName, name))
            }
        }

        composable(
            route= Screens.RepoDetailsScreen.route,
            arguments = listOf(
                navArgument(OWNER_ARGUMENT_KEY){
                    type = NavType.StringType
                },
                navArgument(NAME_ARGUMENT_KEY){
                    type = NavType.StringType
                }
            )
        ){
                navBackStackEntry ->
            val owner = navBackStackEntry.arguments?.getString(OWNER_ARGUMENT_KEY)
            val name = navBackStackEntry.arguments?.getString(NAME_ARGUMENT_KEY)
            if (owner != null && name !=null) {
                RepoDetailsScreen(
                    owner = owner,
                    name = name,
                    onShowIssuesClicked = {
                        navController.navigate(Screens.IssuesListScreen.route)
                    },
                    onClickBack = { navController.popBackStack() },
                )


            }
        }
        composable(route = Screens.IssuesListScreen.route) {
            IssuesScreen(
                issuesUiState = IssuesUiState(
                    issuesList  = listOf(issuesUiModelPreviewData)
                ),
                onRefreshList = {},
                onBackArrowClicked = {navController.popBackStack()}
            )
        }

    }

}
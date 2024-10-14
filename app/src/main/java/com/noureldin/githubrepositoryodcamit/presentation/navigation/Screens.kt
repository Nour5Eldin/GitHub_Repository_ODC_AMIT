package com.noureldin.githubrepositoryodcamit.presentation.navigation

import com.noureldin.githubrepositoryodcamit.presentation.utils.Constant.Companion.ISSUES_LIST_SCREEN
import com.noureldin.githubrepositoryodcamit.presentation.utils.Constant.Companion.NAME_ARGUMENT_KEY
import com.noureldin.githubrepositoryodcamit.presentation.utils.Constant.Companion.OWNER_ARGUMENT_KEY
import com.noureldin.githubrepositoryodcamit.presentation.utils.Constant.Companion.REPO_DETAILS_SCREEN
import com.noureldin.githubrepositoryodcamit.presentation.utils.Constant.Companion.REPO_LIST_SCREEN

sealed class Screens(val route: String) {
    data object RepoListScreen: Screens(REPO_LIST_SCREEN)
    data object RepoDetailsScreen: Screens("$REPO_DETAILS_SCREEN/{$OWNER_ARGUMENT_KEY}/{$NAME_ARGUMENT_KEY}"){
        fun passOwnerAndName(owner: String, name: String): String{
            return "$REPO_DETAILS_SCREEN/$owner/$name"
        }
    }
    data object IssuesListScreen: Screens(ISSUES_LIST_SCREEN)
}
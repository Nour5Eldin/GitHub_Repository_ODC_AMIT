package com.noureldin.githubrepositoryodcamit.presentation.screens.repo_list_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.noureldin.githubrepositoryodcamit.R
import com.noureldin.githubrepositoryodcamit.presentation.common_component.AppBar
import com.noureldin.githubrepositoryodcamit.presentation.common_component.ErrorSection
import com.noureldin.githubrepositoryodcamit.presentation.common_component.shimmer.repo_list.AnimateShimmerRepoList
import com.noureldin.githubrepositoryodcamit.presentation.screens.repo_list_screen.component.RepoItem
import com.noureldin.githubrepositoryodcamit.presentation.screens.repo_list_screen.model.RepoListUiState
import com.noureldin.githubrepositoryodcamit.presentation.screens.repo_list_screen.preview_data.fakeRepoListErrorUiState
import com.noureldin.githubrepositoryodcamit.presentation.screens.repo_list_screen.preview_data.fakeRepoListLoadingUiState
import com.noureldin.githubrepositoryodcamit.presentation.screens.repo_list_screen.preview_data.fakeRepoListUiState
import com.noureldin.githubrepositoryodcamit.presentation.screens.repo_list_screen.viewmodel.RepoListViewModel
import com.noureldin.githubrepositoryodcamit.presentation.theme.GitHubRepositoryODCAMITTheme

@Composable
fun RepoListScreen(
    onRepoItemClicked: (String, String) -> Unit
) {
    val repoListViewModel: RepoListViewModel = hiltViewModel()
    LaunchedEffect(Unit) {
        repoListViewModel.requestGithubRepoList()
    }
    val repoListUiSate by repoListViewModel.repoListStateFlow.collectAsStateWithLifecycle()
    RepoListContent(
        repoListUiSate = repoListUiSate,
        onRefreshButtonClicked = {
            repoListViewModel.requestGithubRepoList()
        },
        onRepoItemClicked = onRepoItemClicked
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RepoListContent(
    modifier: Modifier = Modifier,
    repoListUiSate: RepoListUiState,
    onRefreshButtonClicked: () -> Unit,
    onRepoItemClicked: (String, String) -> Unit
) {
    Scaffold (modifier = modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background),
        topBar = {
            AppBar(
                title = R.string.app_name,
                showBackButton = false
            )
        }
    ){ innerPadding ->
        when {
            repoListUiSate.isLoading -> {
                AnimateShimmerRepoList(
                    innerPadding = innerPadding
                )
            }
            repoListUiSate.isError -> {
                repoListUiSate.customRemoteExceptionUiModel?.let {
                    ErrorSection(
                        innerPadding = innerPadding,
                        customErrorExceptionUiModel = it,
                        onRefreshButtonClicked = {
                            onRefreshButtonClicked()
                        }
                    )
                }
            }
            repoListUiSate.repoList.isNotEmpty() -> {
                LazyColumn(
                    Modifier.padding(innerPadding)
                        .padding(horizontal = 16.dp)
                        .padding(bottom = 16.dp)
                ) {
                    items(repoListUiSate.repoList) { githubRepoUiModel ->
                        RepoItem(
                            githubReposUiModel = githubRepoUiModel,
                            onRepoItemClicked = onRepoItemClicked
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun PreviewRepoListScreen() {
    GitHubRepositoryODCAMITTheme {
        RepoListContent(
            repoListUiSate = fakeRepoListUiState ,
            onRefreshButtonClicked = {},
            onRepoItemClicked = {_,_ -> }
        )
    }
}

@Preview
@Composable
private fun PreviewRepoListScreenLoading() {
    GitHubRepositoryODCAMITTheme{
        RepoListContent(
            repoListUiSate = fakeRepoListLoadingUiState ,
            onRefreshButtonClicked = {},
            onRepoItemClicked = {_,_ -> }
        )
    }
}

@Preview
@Composable
private fun PreviewRepoListScreenError() {
    GitHubRepositoryODCAMITTheme {
        RepoListContent(
            repoListUiSate = fakeRepoListErrorUiState,
            onRefreshButtonClicked = {},
            onRepoItemClicked = {_,_ -> }
        )
    }
}



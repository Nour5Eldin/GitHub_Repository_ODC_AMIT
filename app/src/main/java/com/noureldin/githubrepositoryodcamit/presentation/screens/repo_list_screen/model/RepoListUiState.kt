package com.noureldin.githubrepositoryodcamit.presentation.screens.repo_list_screen.model

import com.noureldin.githubrepositoryodcamit.presentation.model.CustomRemoteExceptionUiModel


data class RepoListUiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val customRemoteExceptionUiModel: CustomRemoteExceptionUiModel = CustomRemoteExceptionUiModel.Unknown,
    val repoList: List<GithubReposUiModel> = emptyList()
)

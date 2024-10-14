package com.noureldin.githubrepositoryodcamit.presentation.screens.repo_isuues_screen.component

import com.noureldin.githubrepositoryodcamit.presentation.model.CustomRemoteExceptionUiModel
import com.noureldin.githubrepositoryodcamit.presentation.screens.repo_isuues_screen.model.IssuesUiModel

data class IssuesUiState(
    val issuesList: List<IssuesUiModel>? = null,
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val customErrorExceptionUiModel: CustomRemoteExceptionUiModel = CustomRemoteExceptionUiModel.Unknown
)
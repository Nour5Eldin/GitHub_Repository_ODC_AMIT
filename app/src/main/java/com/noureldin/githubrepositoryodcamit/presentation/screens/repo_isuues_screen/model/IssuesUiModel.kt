package com.noureldin.githubrepositoryodcamit.presentation.screens.repo_isuues_screen.model

import com.noureldin.githubrepositoryodcamit.domain.model.IssueState

data class IssuesUiModel(
    val id:Int,
    val title: String,
    val author: String,
    val date: String,
    val state: IssueState,
)
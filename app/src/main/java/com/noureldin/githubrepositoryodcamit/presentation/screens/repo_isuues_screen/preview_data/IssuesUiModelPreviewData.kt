package com.noureldin.githubrepositoryodcamit.presentation.screens.repo_isuues_screen.preview_data

import com.noureldin.githubrepositoryodcamit.domain.model.IssueState
import com.noureldin.githubrepositoryodcamit.presentation.screens.repo_isuues_screen.model.IssuesUiModel

val issuesUiModelPreviewData = IssuesUiModel(
    id = 12345,
    title = "Issue Title",
    author = "Seif",
    date = "Created At: 2023-01-01, 14:00 PM",
    state = IssueState.Open
)
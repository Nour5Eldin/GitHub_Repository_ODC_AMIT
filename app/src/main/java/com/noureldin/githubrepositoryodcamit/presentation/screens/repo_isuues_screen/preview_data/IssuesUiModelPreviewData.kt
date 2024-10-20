package com.noureldin.githubrepositoryodcamit.presentation.screens.repo_isuues_screen.preview_data

import com.noureldin.githubrepositoryodcamit.domain.model.IssueState
import com.noureldin.githubrepositoryodcamit.presentation.screens.repo_isuues_screen.model.IssuesUiModel

val issuesUiModelPreviewData = listOf(
    IssuesUiModel(
        id = 53345,
        title = "Issues Fixing DataStore in Repo App",
        author = "Nour",
        date = "Created At: 2024-10-20, 14:00 PM",
        state = IssueState.Closed
    ),
    IssuesUiModel(
        id = 12345,
        title = "Issues in domain Module connecting to main project",
        author = "Nour",
        date = "Created At: 2024-9-15, 14:00 PM",
        state = IssueState.Open
    ),
    IssuesUiModel(
        id = 53345,
        title = "Issues Provide Issues List in Github",
        author = "Nour",
        date = "Created At: 2024-10-20, 14:00 PM",
        state = IssueState.Closed
    ),
)

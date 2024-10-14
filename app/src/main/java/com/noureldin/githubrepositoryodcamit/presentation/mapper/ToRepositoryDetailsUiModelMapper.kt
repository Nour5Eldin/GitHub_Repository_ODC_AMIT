package com.noureldin.githubrepositoryodcamit.presentation.mapper

import com.noureldin.githubrepositoryodcamit.presentation.screens.repo_details_screen.model.RepoDetailsUiModel
import com.noureldin.githubrepositoryodcamit.domain.model.RepoDetailsDomainModel

fun RepoDetailsDomainModel.toRepoDetailsUiModel(): RepoDetailsUiModel {
    return RepoDetailsUiModel(
        id = id,
        name = name,
        avatar = avatar,
        description = description,
        stars = stars.toString(),
        owner = owner,
        forks = forks.toString(),
        language = language,
        fullName = fullName,
        url = url,
        createdAt = createdAt
    )
}
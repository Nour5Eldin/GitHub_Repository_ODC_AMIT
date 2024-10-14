package com.noureldin.githubrepositoryodcamit.presentation.mapper

import com.noureldin.githubrepositoryodcamit.domain.model.GithubReposDomainModel
import com.noureldin.githubrepositoryodcamit.presentation.screens.repo_list_screen.model.GithubReposUiModel


fun GithubReposDomainModel.toGithubReposUiModel(): GithubReposUiModel {
    return GithubReposUiModel(
        id = this.id,
        name = this.name,
        avatarUrl = this.avatar,
        description = this.description,
        starsCount = this.stars.toString(),
        ownerName = this.ownerName
    )
}
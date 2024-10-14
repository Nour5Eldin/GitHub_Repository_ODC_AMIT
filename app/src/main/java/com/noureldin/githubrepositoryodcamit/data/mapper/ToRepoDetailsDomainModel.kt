package com.noureldin.githubrepositoryodcamit.data.mapper


import com.noureldin.githubrepositoryodcamit.data.data_source.remote.retrofit.data_model.repo_details.RepoDetailsDataModel
import com.noureldin.githubrepositoryodcamit.domain.model.RepoDetailsDomainModel

fun RepoDetailsDataModel.toRepoDetailsDomainModel(): RepoDetailsDomainModel {
    return RepoDetailsDomainModel(
        id = this.id,
        name = this.name,
        owner = this.owner.login,
        avatar = this.owner.avatar_url,
        stars = this.stargazers_count,
        description = this.description,
        fullName = this.full_name,
        forks = this.forks,
        url = this.url,
        createdAt = created_at,
        language = this.language ?: ""
    )
}
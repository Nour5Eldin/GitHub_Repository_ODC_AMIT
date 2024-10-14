package com.noureldin.githubrepositoryodcamit.data.mapper


import com.noureldin.githubrepositoryodcamit.data.data_source.remote.retrofit.data_model.repo_list.Item
import com.noureldin.githubrepositoryodcamit.domain.model.GithubReposDomainModel

fun Item.toGithubReposDomainModel(): GithubReposDomainModel {
    return GithubReposDomainModel(
        id = this.id,
        name = this.name,
        ownerName = this.owner.login,
        avatar = this.owner.avatar_url,
        stars = this.stargazers_count,
        description = this.description
    )
}
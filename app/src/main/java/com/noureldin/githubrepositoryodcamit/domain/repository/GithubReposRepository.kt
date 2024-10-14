package com.noureldin.githubrepositoryodcamit.domain.repository

import com.noureldin.githubrepositoryodcamit.domain.model.GithubReposDomainModel
import com.noureldin.githubrepositoryodcamit.domain.model.RepoDetailsDomainModel

interface GithubReposRepository {
    suspend fun fetchReposList(): List<GithubReposDomainModel>
    suspend fun fetchRepoDetails(ownerName: String, name: String): RepoDetailsDomainModel
}
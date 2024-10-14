package com.noureldin.githubrepositoryodcamit.data.repository

import com.noureldin.githubrepositoryodcamit.data.data_source.local.GithubLocalDataSource
import com.noureldin.githubrepositoryodcamit.data.data_source.remote.GithubRemoteDataSource
import com.noureldin.githubrepositoryodcamit.data.mapper.toGithubReposDomainModel
import com.noureldin.githubrepositoryodcamit.data.mapper.toRepoDetailsDomainModel
import com.noureldin.githubrepositoryodcamit.domain.model.GithubReposDomainModel
import com.noureldin.githubrepositoryodcamit.domain.model.RepoDetailsDomainModel
import com.noureldin.githubrepositoryodcamit.domain.repository.GithubReposRepository
import javax.inject.Inject

class GithubReposRepositoryImpl @Inject constructor(
    private val githubRemoteDataSource: GithubRemoteDataSource,
    private val githubLocalDataSource: GithubLocalDataSource,
): GithubReposRepository {
    override suspend fun fetchReposList(): List<GithubReposDomainModel> {
        return githubRemoteDataSource.fetchRepositoriesList().items.map {
            it.toGithubReposDomainModel()
        }
    }

    override suspend fun fetchRepoDetails(ownerName: String, name: String): RepoDetailsDomainModel {
        return githubRemoteDataSource.fetchRepoDetails(ownerName, name).toRepoDetailsDomainModel()
    }
}
package com.noureldin.githubrepositoryodcamit.domain.usecase

import com.noureldin.githubrepositoryodcamit.domain.model.RepoDetailsDomainModel
import com.noureldin.githubrepositoryodcamit.domain.repository.GithubReposRepository
import javax.inject.Inject


class FetchRepositoryDetailsUseCase @Inject constructor(
    private val githubReposRepository: GithubReposRepository
) {
    suspend operator fun invoke(
        ownerName:String, name:String
    ): RepoDetailsDomainModel {
        return githubReposRepository.fetchRepoDetails(ownerName, name)
    }
}
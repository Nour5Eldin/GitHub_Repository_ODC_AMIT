package com.noureldin.githubrepositoryodcamit.domain.usecase

import com.noureldin.githubrepositoryodcamit.domain.model.GithubReposDomainModel
import com.noureldin.githubrepositoryodcamit.domain.repository.GithubReposRepository
import javax.inject.Inject

class FetchGithubReposListUseCase @Inject constructor(
    private val githubReposRepository: GithubReposRepository
) {
    suspend operator fun invoke(): List<GithubReposDomainModel> {
        return githubReposRepository.fetchReposList()
    }
}

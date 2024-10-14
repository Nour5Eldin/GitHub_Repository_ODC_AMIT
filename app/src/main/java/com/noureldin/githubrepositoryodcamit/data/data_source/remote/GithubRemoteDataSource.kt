package com.noureldin.githubrepositoryodcamit.data.data_source.remote

import com.noureldin.githubrepositoryodcamit.data.data_source.remote.retrofit.api.RepoDetailsApi
import com.noureldin.githubrepositoryodcamit.data.data_source.remote.retrofit.api.RepositoriesListApi
import com.noureldin.githubrepositoryodcamit.data.data_source.remote.retrofit.data_model.repo_details.RepoDetailsDataModel
import com.noureldin.githubrepositoryodcamit.data.data_source.remote.retrofit.data_model.repo_list.GithubReposDataModel
import javax.inject.Inject

class GithubRemoteDataSource @Inject constructor(
    private val repositoryListApi: RepositoriesListApi,
    private val repositoryDetailsApi: RepoDetailsApi
) {
    suspend fun fetchRepositoriesList(): GithubReposDataModel {
        try {
            return repositoryListApi.fetchRepositoriesList().body() as GithubReposDataModel
        }catch (e: Exception){
            throw e

        }
    }

    suspend fun fetchRepoDetails(ownerName: String, name: String): RepoDetailsDataModel {
        try {
            return repositoryDetailsApi.fetchRepoDetails(ownerName, name).body() as RepoDetailsDataModel
        } catch (e: Exception) {
            // Convert and rethrow the exception as a custom remote exception
            throw e
        }
    }
}
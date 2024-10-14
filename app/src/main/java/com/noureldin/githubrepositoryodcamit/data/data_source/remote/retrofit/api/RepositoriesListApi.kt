package com.noureldin.githubrepositoryodcamit.data.data_source.remote.retrofit.api

import com.noureldin.githubrepositoryodcamit.data.Constants.Companion.GITHUB_REPOS_ENDPOINT
import com.noureldin.githubrepositoryodcamit.data.data_source.remote.retrofit.data_model.repo_list.GithubReposDataModel
import retrofit2.Response
import retrofit2.http.GET

interface RepositoriesListApi {
    @GET(GITHUB_REPOS_ENDPOINT)
    suspend fun fetchRepositoriesList(): Response<GithubReposDataModel>
}
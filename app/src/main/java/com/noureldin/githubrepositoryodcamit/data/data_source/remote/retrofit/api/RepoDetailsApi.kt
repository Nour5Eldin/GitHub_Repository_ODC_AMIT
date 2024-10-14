package com.noureldin.githubrepositoryodcamit.data.data_source.remote.retrofit.api

import com.noureldin.githubrepositoryodcamit.data.Constants.Companion.OWNER_KEY
import com.noureldin.githubrepositoryodcamit.data.Constants.Companion.REPO_NAME_KEY
import com.noureldin.githubrepositoryodcamit.data.data_source.remote.retrofit.data_model.repo_details.RepoDetailsDataModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RepoDetailsApi {
    @GET("repos/{$OWNER_KEY}/{$REPO_NAME_KEY}")
    suspend fun fetchRepoDetails(
        @Path(OWNER_KEY) ownerName: String,
        @Path(REPO_NAME_KEY) name : String
    ) : Response<RepoDetailsDataModel>
}
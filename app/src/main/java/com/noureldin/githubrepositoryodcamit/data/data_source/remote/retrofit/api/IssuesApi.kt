package com.noureldin.githubrepositoryodcamit.data.data_source.remote.retrofit.api

import com.noureldin.githubrepositoryodcamit.data.Constants.Companion.OWNER_KEY
import com.noureldin.githubrepositoryodcamit.data.Constants.Companion.REPO_NAME_KEY
import com.noureldin.githubrepositoryodcamit.data.data_source.remote.retrofit.data_model.issues_list.IssuesDataModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface IssuesApi {
    @GET("repos/{$OWNER_KEY}/{$REPO_NAME_KEY}/issues")
    suspend fun fetchIssues(
        @Path(OWNER_KEY) owner: String,
        @Path(REPO_NAME_KEY) name: String
    ): Response<IssuesDataModel>
}
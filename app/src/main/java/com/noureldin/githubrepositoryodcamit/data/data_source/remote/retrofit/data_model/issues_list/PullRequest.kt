package com.noureldin.githubrepositoryodcamit.data.data_source.remote.retrofit.data_model.issues_list

data class PullRequest(
    val diff_url: String,
    val html_url: String,
    val merged_at: Any,
    val patch_url: String,
    val url: String
)
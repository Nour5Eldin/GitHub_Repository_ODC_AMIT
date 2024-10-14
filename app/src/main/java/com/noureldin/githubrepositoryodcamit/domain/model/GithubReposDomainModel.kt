package com.noureldin.githubrepositoryodcamit.domain.model

data class GithubReposDomainModel(
    val id: Long,
    val avatar: String,
    val name: String,
    val ownerName: String,
    val description:String,
    val stars:Int
)

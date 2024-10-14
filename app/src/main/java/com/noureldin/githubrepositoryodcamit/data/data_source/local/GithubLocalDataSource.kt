package com.noureldin.githubrepositoryodcamit.data.data_source.local

import com.noureldin.githubrepositoryodcamit.data.data_source.local.room.RepoListDao
import com.noureldin.githubrepositoryodcamit.data.data_source.local.room.ReposListEntity
import javax.inject.Inject

class GithubLocalDataSource @Inject constructor(
    private val repoListDao: RepoListDao
) {
    suspend fun getTrendingList(): List<ReposListEntity>{
        return repoListDao.getReposList()
    }
    suspend fun insertRepos(repoList: List<ReposListEntity>){
        repoListDao.insertReposList(repoList)
    }
}
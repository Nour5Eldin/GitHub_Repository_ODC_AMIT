package com.noureldin.githubrepositoryodcamit.data.data_source.local

import com.noureldin.githubrepositoryodcamit.data.data_source.local.data_store.DataStorePreference
import com.noureldin.githubrepositoryodcamit.data.data_source.local.room.RepoListDao
import com.noureldin.githubrepositoryodcamit.data.data_source.local.room.ReposListEntity
import javax.inject.Inject

class GithubLocalDataSource @Inject constructor(
    private val repoListDao: RepoListDao,
    private val dataStorePreference: DataStorePreference
) {
    fun getTrendingRepositories(): List<ReposListEntity> {
        return repoListDao.getTrendingRepositories()
    }

    suspend fun insertTrendingRepositories(githubRepositoriesEntity: List<ReposListEntity>) {
        repoListDao.insertTrendingRepositories(githubRepositoriesEntity)
    }

    suspend fun readIsFirstTime(): Boolean { // support flows
        return dataStorePreference.readIsFirstTime()
    }

    suspend fun saveIsFirstTime(isFirstTime: Boolean) {
        dataStorePreference.saveIsFirstTime(isFirstTime = isFirstTime)
    }
}
package com.noureldin.githubrepositoryodcamit.data.data_source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RepoListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrendingRepositories(githubRepositoriesEntity: List<ReposListEntity>)

    @Query("SELECT * FROM GITHUB_REPOSITORIES_TABLE")
    fun getTrendingRepositories(): List<ReposListEntity>
}
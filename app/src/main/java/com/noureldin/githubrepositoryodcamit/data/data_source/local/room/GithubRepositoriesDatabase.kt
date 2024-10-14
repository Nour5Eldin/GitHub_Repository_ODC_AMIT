package com.noureldin.githubrepositoryodcamit.data.data_source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ReposListEntity::class],
    version = 1,
    exportSchema = false
)
abstract class GithubRepositoriesDatabase: RoomDatabase() {
    abstract fun  repoListDao(): RepoListDao
}
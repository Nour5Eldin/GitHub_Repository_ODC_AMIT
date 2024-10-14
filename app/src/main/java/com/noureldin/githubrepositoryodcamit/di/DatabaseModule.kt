package com.noureldin.githubrepositoryodcamit.di

import android.content.Context
import androidx.room.Room
import com.noureldin.githubrepositoryodcamit.data.data_source.local.data_store.DataStorePreference
import com.noureldin.githubrepositoryodcamit.data.data_source.local.room.GithubRepositoriesDatabase
import com.noureldin.githubrepositoryodcamit.data.data_source.local.room.RepoListDao
import com.noureldin.githubrepositoryodcamit.presentation.utils.Constant.Companion.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideGithubRepositoriesDatabase(
        @ApplicationContext context: Context
    ): GithubRepositoriesDatabase {
        return Room.databaseBuilder(
            context,
            GithubRepositoriesDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideRepoListDao(
        githubRepositoriesDatabase: GithubRepositoriesDatabase
    ): RepoListDao {
        return githubRepositoriesDatabase.repoListDao()
    }

    @Singleton
    @Provides
    fun provideDataStorePreference(
        @ApplicationContext context: Context
    ) = DataStorePreference(context)

}
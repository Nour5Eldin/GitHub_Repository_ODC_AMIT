package com.noureldin.githubrepositoryodcamit.di

import com.noureldin.githubrepositoryodcamit.data.data_source.local.GithubLocalDataSource
import com.noureldin.githubrepositoryodcamit.data.data_source.remote.GithubRemoteDataSource
import com.noureldin.githubrepositoryodcamit.data.repository.GithubReposRepositoryImpl
import com.noureldin.githubrepositoryodcamit.domain.repository.GithubReposRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideGithubReposRepository(
        githubRemoteDataSource: GithubRemoteDataSource,
        localDataSource: GithubLocalDataSource
    ): GithubReposRepository {
        return GithubReposRepositoryImpl(githubRemoteDataSource, localDataSource)
    }
}
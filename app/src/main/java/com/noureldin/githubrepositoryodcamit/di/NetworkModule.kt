package com.noureldin.githubrepositoryodcamit.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.noureldin.githubrepositoryodcamit.data.Constants.Companion.BASE_URL
import com.noureldin.githubrepositoryodcamit.data.data_source.remote.retrofit.api.RepoDetailsApi
import com.noureldin.githubrepositoryodcamit.data.data_source.remote.retrofit.api.RepositoriesListApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRepositoriesListApi(
        retrofit: Retrofit
    ): RepositoriesListApi {
        return retrofit.create(RepositoriesListApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepoDetailsApi(
        retrofit: Retrofit
    ): RepoDetailsApi {
        return retrofit.create(RepoDetailsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        @ApplicationContext context: Context
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(ChuckerInterceptor(context))
            .build()
    }


    @Provides
    @Singleton
    fun provideRetrofitInstance(
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
package com.noureldin.githubrepositoryodcamit.data.data_source.local.room

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RepositoriesTypeConverter {
    @TypeConverter
    fun trendingRepositoriesToString(trendingRepositoriesResponse: List<RepoListDao>):String {
        return Gson().toJson(trendingRepositoriesResponse)
    }
    @TypeConverter
    fun fromStringToTrendingRepositories(data: String):List<RepoListDao> {
        val listType = object : TypeToken<List<RepoListDao>>(){}.type
        return Gson().fromJson(data,listType)
    }
}
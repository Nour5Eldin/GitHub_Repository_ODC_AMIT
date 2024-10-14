package com.noureldin.githubrepositoryodcamit.data.data_source.local.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.noureldin.githubrepositoryodcamit.data.Constants.Companion.GITHUB_REPOSITORIES_TABLE

@Entity(tableName = GITHUB_REPOSITORIES_TABLE)
data class ReposListEntity(
    @PrimaryKey(autoGenerate = false)
    val id:Long,
    val name:String,
    val avatar:String,
    val ownerName:String,
    val description:String,
    val starsCount: String
)
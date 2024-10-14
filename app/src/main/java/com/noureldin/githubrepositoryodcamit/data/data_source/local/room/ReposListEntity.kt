package com.noureldin.githubrepositoryodcamit.data.data_source.local.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ReposListEntity(
    @PrimaryKey(autoGenerate = false)
    val id:Long,
    val name:String,
    val avatar:String,
    val ownerName:String,
    val description:String,
    val starsCount: String
)
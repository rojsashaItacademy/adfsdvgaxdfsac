package com.example.news.data.model.news

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SourceModel (
    @PrimaryKey(autoGenerate = true)
    val primaryId : Int, //?
    val id: String?, //???
    val name : String
)
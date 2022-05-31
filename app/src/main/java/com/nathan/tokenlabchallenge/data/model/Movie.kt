package com.nathan.tokenlabchallenge.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "movie_table")
data class Movie(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "movie_id")
    val id: Int,
    @ColumnInfo(name = "movie_poster_url")
    var poster_url : String? = "",
    @ColumnInfo(name = "movie_overview")
    var overview : String? = "",
    @ColumnInfo(name = "movie_release_date")
    var release_date : String? = "",
    @ColumnInfo(name = "movie_genres")
    var genres : String? = "",
    @ColumnInfo(name = "movie_original_language")
    var original_language : String? = "",
    @ColumnInfo(name = "movie_title")
    var title : String? = "",
    @ColumnInfo(name = "movie_vote_average")
    var vote_average: Double? = 0.0
) : Serializable

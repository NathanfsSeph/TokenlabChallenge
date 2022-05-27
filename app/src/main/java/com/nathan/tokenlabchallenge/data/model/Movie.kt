package com.nathan.tokenlabchallenge.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.Serializable

//@Entity(tableName = "movie_table")
data class Movie(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "movie_id")
    val id: Int,
    @ColumnInfo(name = "movie_poster_url")
    val poster_url : String? = "",
    @ColumnInfo(name = "movie_overview")
    val overview : String? = "",
    @ColumnInfo(name = "movie_release_date")
    val release_date : String? = "",
    @ColumnInfo(name = "movie_genres")
    val genres : List<String>? = listOf("None"),
    @ColumnInfo(name = "movie_original_language")
    val original_language : String? = "",
    @ColumnInfo(name = "movie_title")
    val title : String? = "",
    @ColumnInfo(name = "movie_vote_average")
    val vote_average: Double? = 0.0
) : Serializable

//class GenresConverter{
//    @TypeConverter
//    fun fromString(value: String) : List<String> {
//
//        val listType = object : TypeToken<List<String>>(){}.type
//
//        return Gson().fromJson(value, listType)
//    }
//
//    @TypeConverter
//    fun fromList(list: List<String?>) : String {
//
//        return Gson().toJson(list)
//    }
//}
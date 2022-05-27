package com.nathan.tokenlabchallenge.data.database

import androidx.room.*
import com.nathan.tokenlabchallenge.data.model.Movie
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDAO {

    @Insert
    suspend fun insertMovie(movie: Movie) : Long

    @Update
    suspend fun updateMovie(movie: Movie) : Int

    @Delete
    suspend fun deleteMovie(movie: Movie) : Int

    @Query("DELETE FROM movie_table")
    fun deleteAll() : Int

    @Query("SELECT * FROM movie_table")
    fun getAllMovie(): Flow<List<Movie>>

}
package com.nathan.tokenlabchallenge.data.database

import androidx.room.*
import com.nathan.tokenlabchallenge.data.model.Movie
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movies: Movie) : Long

    @Update
    fun updateMovie(movie: Movie) : Int

    @Query("DELETE FROM movie_table")
    fun deleteAll() : Int

    @Query("SELECT * FROM movie_table")
    fun getAllMovies(): List<Movie>

}
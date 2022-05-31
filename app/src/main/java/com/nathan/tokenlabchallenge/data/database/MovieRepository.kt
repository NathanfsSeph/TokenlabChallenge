package com.nathan.tokenlabchallenge.data.database

import com.nathan.tokenlabchallenge.data.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieRepository (private val dao: MovieDAO) {


    suspend fun getAllMovies() : List<Movie> = withContext(Dispatchers.IO) {
        return@withContext dao.getAllMovies()
    }

    suspend fun insert(movie: Movie) : Long = withContext(Dispatchers.IO) {
        return@withContext dao.insertMovie(movie)
    }

    suspend fun update(movie: Movie): Int = withContext(Dispatchers.IO) {
        return@withContext dao.updateMovie(movie)
    }


    suspend fun deleteAll() : Int = withContext(Dispatchers.IO) {
        return@withContext dao.deleteAll()
    }

}
package com.nathan.tokenlabchallenge.data.database

import com.nathan.tokenlabchallenge.data.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieRepository (private val dao: MovieDAO) {


    suspend fun getAllMovies() : List<Movie> = withContext(Dispatchers.IO){
        return@withContext dao.getAllMovies()
    }

    suspend fun insert(movie: Movie) : Long {
        return dao.insertMovie(movie)
    }

    suspend fun update(movie: Movie): Int {
        return dao.updateMovie(movie)
    }


    fun deleteAll() : Int {
        return dao.deleteAll()
    }

}
package com.nathan.tokenlabchallenge.data.database

import com.nathan.tokenlabchallenge.data.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieRepositoryImpl (private val dao: MovieDAO) : MovieRepository {


    override suspend fun getAllMovies() : List<Movie> = withContext(Dispatchers.IO) {
        return@withContext dao.getAllMovies()
    }

    override suspend fun insert(movie: Movie) : Long = withContext(Dispatchers.IO) {
        return@withContext dao.insertMovie(movie)
    }

    override suspend fun update(movie: Movie): Int = withContext(Dispatchers.IO) {
        return@withContext dao.updateMovie(movie)
    }


    override suspend fun deleteAll() : Int = withContext(Dispatchers.IO) {
        return@withContext dao.deleteAll()
    }

}
package com.nathan.tokenlabchallenge.data.database

import com.nathan.tokenlabchallenge.data.model.Movie

class MovieRepository (private val dao: MovieDAO) {

    val movies = dao.getAllMovie()

    suspend fun insert(movie: Movie): Long {
        return dao.insertMovie(movie)
    }

    suspend fun update(movie: Movie): Int {
        return dao.updateMovie(movie)
    }

    suspend fun delete(movie: Movie): Int {
        return dao.deleteMovie(movie)
    }

    fun deleteAll(): Int {
        return dao.deleteAll()
    }

}
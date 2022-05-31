package com.nathan.tokenlabchallenge.data.database

import com.nathan.tokenlabchallenge.data.model.Movie

interface MovieRepository {
    suspend fun getAllMovies() : List<Movie>

    suspend fun insert(movie: Movie) : Long

    suspend fun update(movie: Movie): Int


    suspend fun deleteAll() : Int
}
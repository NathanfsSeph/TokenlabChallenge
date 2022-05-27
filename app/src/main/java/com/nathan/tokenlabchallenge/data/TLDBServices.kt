package com.nathan.tokenlabchallenge.data

import com.nathan.tokenlabchallenge.data.response.MovieBodyResponse
import com.nathan.tokenlabchallenge.data.response.MovieDetailsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface TLDBServices {

    @GET("movies-v2")
    fun getMovies(): Call<MovieBodyResponse>


    @GET("movies-v2/{id}")
    fun getSpecificMovie(
        @Path(value = "id") movieId: Int
    ): Call<MovieDetailsResponse>


}
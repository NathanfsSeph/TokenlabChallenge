package com.nathan.tokenlabchallenge.data.response

data class MovieDetailsResponse(
    val genres: List<String>,
    val id: Int,
    val original_language: String,
    val overview: String,
    val poster_url: String,
    val release_date: String,
    val title: String,
    val vote_average: Double,
)
package com.nathan.tokenlabchallenge.data.response

data class MovieResultResponse(
    val genres: List<String>,
    val id: Int,
    val poster_url: String,
    val release_date: String,
    val title: String,
    val vote_average: Double
)
package com.nathan.tokenlabchallenge.presentation.main

import com.nathan.tokenlabchallenge.data.model.Movie

data class MainScreenState(
    val movies: List<Movie> = listOf()
)
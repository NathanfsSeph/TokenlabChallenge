package com.nathan.tokenlabchallenge.presentation.main

import com.nathan.tokenlabchallenge.data.model.Movie
import kotlinx.coroutines.flow.Flow

data class MainScreenState(
    val movies: List<Movie> = listOf(),
    var isLoading: Boolean = false
)
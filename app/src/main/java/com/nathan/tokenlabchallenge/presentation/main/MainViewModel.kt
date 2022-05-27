package com.nathan.tokenlabchallenge.presentation.main

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nathan.tokenlabchallenge.data.APIService
import com.nathan.tokenlabchallenge.data.model.Movie
import com.nathan.tokenlabchallenge.data.response.MovieBodyResponse
import com.nathan.tokenlabchallenge.data.response.MovieDetailsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(
    private val context: Context
) : ViewModel() {

    private val _mainScreenState: MutableLiveData<MainScreenState> = MutableLiveData()
    val mainScreenState: LiveData<MainScreenState> get() = _mainScreenState

    init {
        _mainScreenState.value = MainScreenState()
    }

    fun getMovies() {
        APIService.service.getMovies()
            .enqueue(object : Callback<MovieBodyResponse> {
                override fun onResponse(
                    call: Call<MovieBodyResponse>,
                    response: Response<MovieBodyResponse>
                ) {
                    if (response.isSuccessful) {
                        val movies: MutableList<Movie> = mutableListOf()

                        response.body()?.let { movieBodyResponse ->
                            for (result in movieBodyResponse) {
                                val movie = Movie(
                                    id = result.id,
                                    poster_url = result.poster_url,
                                    release_date = result.release_date,
                                    genres = result.genres,
                                    vote_average = result.vote_average,
                                    title = result.title
                                )
                                movies.add(movie)
                            }
                        }

                        _mainScreenState.value = mainScreenState.value?.copy(
                            movies = movies
                        )

                    }
                }

                override fun onFailure(call: Call<MovieBodyResponse>, t: Throwable) {

                }

            })

    }

    fun getSpecificMovie(movieId: Int) {

        APIService.service.getSpecificMovie(movieId)
            .enqueue(object : Callback<MovieDetailsResponse> {

                override fun onResponse(
                    call: Call<MovieDetailsResponse>,
                    response: Response<MovieDetailsResponse>
                ) {

                    if (response.isSuccessful) {

                        response.body()?.let { movieDetailsResponse ->
                                val movie = Movie(
                                    id = 1,
                                    poster_url = "movieDetailsResponse.poster_url",
                                    overview = "movieDetailsResponse.overview",
                                    release_date = "movieDetailsResponse.release_date",
                                    genres = listOf(),
                                    vote_average = 8.0,
                                    title = "movieDetailsResponse.title"
                                )
                        }
                    }
                }

                override fun onFailure(call: Call<MovieDetailsResponse>, t: Throwable) {

                }
            })

    }

}
package com.nathan.tokenlabchallenge.presentation.main

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nathan.tokenlabchallenge.data.APIService
import com.nathan.tokenlabchallenge.data.database.MovieDatabase
import com.nathan.tokenlabchallenge.data.database.MovieRepository
import com.nathan.tokenlabchallenge.data.model.Movie
import com.nathan.tokenlabchallenge.data.response.MovieBodyResponse
import com.nathan.tokenlabchallenge.data.response.MovieDetailsResponse
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(
    private val context: Context
) : ViewModel() {

    private val _mainScreenState: MutableLiveData<MainScreenState> = MutableLiveData()
    val mainScreenState: LiveData<MainScreenState> get() = _mainScreenState

    private val dataAccessObject = MovieDatabase.getInstance(context).movieDAO
    private val repository = MovieRepository(dataAccessObject)

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
                                    genres = result.genres.toString(),
                                    vote_average = result.vote_average,
                                    title = result.title
                                )
                                movies.add(movie)

                                viewModelScope.launch {
                                    repository.insert(movie)
                                }

                            }
                        }

                        _mainScreenState.value = mainScreenState.value?.copy(
                            movies = movies
                        )

                    }
                }

                override fun onFailure(call: Call<MovieBodyResponse>, t: Throwable) {

                    viewModelScope.launch {
                        val recoveredMovies = repository.getAllMovies()

                        _mainScreenState.value = mainScreenState.value?.copy(
                                movies = recoveredMovies
                        )
                    }

                }

            })

    }

    fun getSpecificMovie(movieId: Int,oldMovie : Movie) {

        APIService.service.getSpecificMovie(movieId)
            .enqueue(object : Callback<MovieDetailsResponse> {

                override fun onResponse(
                    call: Call<MovieDetailsResponse>,
                    response: Response<MovieDetailsResponse>
                ) {

                    if (response.isSuccessful) {
                        response.body()?.let { movieDetailsResponse ->
                            val updatedMovie = Movie(
                                id = movieDetailsResponse.id,
                                poster_url = movieDetailsResponse.poster_url,
                                overview = movieDetailsResponse.overview,
                                release_date = movieDetailsResponse.release_date,
                                genres = movieDetailsResponse.genres.toString(),
                                vote_average = movieDetailsResponse.vote_average,
                                title = movieDetailsResponse.title
                            )

                            val movieIndex = mainScreenState.value!!.movies.indexOf(oldMovie)

                            mainScreenState.value!!.movies.elementAt(movieIndex).overview = updatedMovie.overview


                            viewModelScope.launch {
                                repository.update(updatedMovie)
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<MovieDetailsResponse>, t: Throwable) {

                }
            })

    }

}
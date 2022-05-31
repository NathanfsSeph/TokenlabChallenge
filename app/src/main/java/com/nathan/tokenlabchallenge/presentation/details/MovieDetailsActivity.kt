package com.nathan.tokenlabchallenge.presentation.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.navArgs
import com.bumptech.glide.Glide
import com.nathan.tokenlabchallenge.R
import kotlinx.android.synthetic.main.activity_movie_details.*

class MovieDetailsActivity : AppCompatActivity() {

    private val args: MovieDetailsActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        val movie = args.movie

        Glide.with(imageMovieDetailsPosterPath)
            .load(movie.poster_url)
            .into(imageMovieDetailsPosterPath)

        textMovieDetailsOverview.text = movie.overview
        textMovieDetailsReleaseDate.text = movie.release_date
        textMovieDetailsGenre.text = movie.genres.toString()
        textMovieDetailsOriginalLanguage.text = movie.original_language
        textMovieDetailsTitle.text = movie.title

    }

}
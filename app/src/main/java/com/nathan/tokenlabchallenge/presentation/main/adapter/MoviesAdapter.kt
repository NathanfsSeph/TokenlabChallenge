package com.nathan.tokenlabchallenge.presentation.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.nathan.tokenlabchallenge.R
import com.nathan.tokenlabchallenge.data.model.Movie
import kotlinx.android.synthetic.main.list_item_movie.view.*

class MoviesAdapter(
    private val listener: OnMovieListener
): RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    private val movies : MutableList<Movie> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_movie, parent,false)

        return MoviesViewHolder(itemView,listener)
    }

    override fun getItemCount() = movies.count()

    override fun onBindViewHolder(viewHolder: MoviesViewHolder, position: Int) {
        viewHolder.bindView(movies[position] )
    }

    class MoviesViewHolder(itemView : View, private val listener: OnMovieListener) : RecyclerView.ViewHolder(itemView){

        private val poster = itemView.imageViewPosterPath
        private val release_date = itemView.textViewReleaseDate
        private val genre_ids = itemView.textViewGenre
        private val title = itemView.textViewTitle

        fun bindView(movie : Movie){

            Glide.with(poster)
                .load(movie.poster_url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(poster)

            release_date.text = movie.release_date
            genre_ids.text = movie.genres.toString()
            title.text = movie.title

            itemView.setOnClickListener{
                listener.onMovieClicked(movie)
            }

        }
    }

    fun updateDataSet(newList : List<Movie>){
        movies.clear()
        movies.addAll(newList)
        notifyDataSetChanged()
    }

}

interface OnMovieListener {
    fun onMovieClicked(movie : Movie)
}
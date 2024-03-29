package com.nathan.tokenlabchallenge.presentation.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.nathan.tokenlabchallenge.R
import com.nathan.tokenlabchallenge.data.model.Movie
import com.nathan.tokenlabchallenge.presentation.main.MainViewModel
import com.nathan.tokenlabchallenge.presentation.main.adapter.MoviesAdapter
import com.nathan.tokenlabchallenge.presentation.main.adapter.OnMovieListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class MainFragment : Fragment(), OnMovieListener {

    private val viewModel: MainViewModel by sharedViewModel()
    private val adapter: MoviesAdapter by lazy { MoviesAdapter(this) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        setupViews()
    }

    private fun setupObservers() {
        viewModel.mainScreenState.observe(viewLifecycleOwner) {
            it?.let {
                adapter.updateDataSet(it.movies)
                progress_bar.isVisible = it.isLoading
            }
        }
    }

    private fun setupViews() {
        with(recyclerView) {
            adapter = this@MainFragment.adapter
        }
    }

    override fun onMovieClicked(movie: Movie) {
        viewModel.getSpecificMovie(movieId = movie.id){
            val movieIndex = viewModel.mainScreenState.value!!.movies.indexOf(movie)

            val action = MainFragmentDirections.actionMainFragmentToMovieDetailsActivity(
                viewModel.mainScreenState.value!!.movies.elementAt(movieIndex)
            )

            findNavController().navigate(action)
        }

    }

}
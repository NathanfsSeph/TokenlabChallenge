package com.nathan.tokenlabchallenge

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nathan.tokenlabchallenge.presentation.main.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private val viewModel : MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getMovies()

    }
}
package com.nathan.tokenlabchallenge.presentation.di

import com.nathan.tokenlabchallenge.data.database.MovieDatabase
import com.nathan.tokenlabchallenge.data.database.MovieRepository
import com.nathan.tokenlabchallenge.data.database.MovieRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModules = module {
    single{
        MovieDatabase.getInstance(androidContext())
    }
    factory <MovieRepository> {
        MovieRepositoryImpl(
            dao = get<MovieDatabase>().movieDAO
        )
    }
}
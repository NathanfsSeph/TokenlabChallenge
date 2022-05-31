package com.nathan.tokenlabchallenge

import android.app.Application
import com.nathan.tokenlabchallenge.presentation.di.dataModules
import com.nathan.tokenlabchallenge.presentation.di.presentationModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApp)
            modules(
                presentationModules,
                dataModules
            )
        }
    }

}
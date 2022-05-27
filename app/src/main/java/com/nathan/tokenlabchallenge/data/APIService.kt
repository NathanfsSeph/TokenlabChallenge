package com.nathan.tokenlabchallenge.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIService {

    private fun initRetrofit() : Retrofit {

        return Retrofit.Builder()
            .baseUrl("https://desafio-mobile.nyc3.digitaloceanspaces.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val service : TLDBServices = initRetrofit().create(TLDBServices::class.java)

}
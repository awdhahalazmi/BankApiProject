package com.joincoded.bankapi.singleton

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroFitHelper {
    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://coded-bank-api.eapi.joincoded.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    }

}
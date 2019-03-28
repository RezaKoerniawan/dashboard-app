package com.reza.base.network

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * @author reza.kurniawan
 * @date 10-Mar-2019
 */
object RetrofitApi {

    fun getRetrofit(url: String): Retrofit {
        val gson = GsonBuilder().setLenient().create()

        return Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
    }
}
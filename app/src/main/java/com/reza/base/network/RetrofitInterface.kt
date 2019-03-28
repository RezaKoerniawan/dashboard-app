package com.reza.base.network

import com.reza.base.entity.MovieItem
import retrofit2.Call
import retrofit2.http.GET


/**
 * Created by Reza Kurniawan on 28/03/2019.
 */

interface RetrofitInterface {
    @get:GET("v2/5c9bbc923600007b00d96e02")
    val allPost: Call<List<MovieItem>>
}
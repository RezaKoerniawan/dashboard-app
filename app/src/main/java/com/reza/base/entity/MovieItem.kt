package com.reza.base.entity

import com.google.gson.annotations.SerializedName

data class MovieItem(
        @SerializedName("title")
        val title: String,
        @SerializedName("image")
        val image: String,
        @SerializedName("price")
        val price: String
)
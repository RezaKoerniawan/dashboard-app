package com.reza.base.network

import com.reza.base.BuildConfig


/**
 * Copyright © 2018 PT. MetraPlasa.
 *
 * Created by Reza Kurniawan on 28/03/2019.
 */

object ApiUtil {
    val serviceClass: RetrofitInterface
        get() = RetrofitApi.getRetrofit(BuildConfig.API_MOVIES).create(RetrofitInterface::class.java)
}
package com.reza.base.core

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

/**
 * @author reza.kurniawan
 * @date 3-Mar-19
 */
interface BaseView : LifecycleOwner {

    fun <T> observeData(data: LiveData<T>, observer: Observer<T>) {
        data.observe(this, observer)
    }

    fun <T> observeData(data: LiveData<T>, onChanged: (T?) -> Unit) {
        observeData(data, Observer { onChanged(it) })
    }
}
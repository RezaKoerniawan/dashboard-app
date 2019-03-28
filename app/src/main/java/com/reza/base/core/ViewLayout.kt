package com.reza.base.core

import androidx.annotation.LayoutRes
import androidx.annotation.NonNull
import android.view.View

/**
 * @author reza.kurniawan
 * @date 21-Nov-18
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class ViewLayout(@LayoutRes @NonNull val value: Int = View.NO_ID)

package com.reza.base.util

import android.content.Context
import android.content.SharedPreferences

/**
 * @author reza.kurniawan
 * @date 10-Mar-2019
 */
object PrefManager {
    private const val NAME = "BasePref"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences

    private val IS_FIRST_OPEN = Pair("IS_FIRST_OPEN", true)
    private val IS_USER_LOGIN = Pair("IS_USER_LOGIN_PREF", false)
    private val USER_DATA = Pair("USER_DATA_PREF", "")

    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    /**
     * SharedPreferences extension function, so we won't need to call edit()
     * and apply() ourselves on every SharedPreferences operation.
     */
    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var firstOpen: Boolean
        get() = preferences.getBoolean(IS_FIRST_OPEN.first, IS_FIRST_OPEN.second)
        set(value) = preferences.edit {
            it.putBoolean(IS_FIRST_OPEN.first, value)
        }

    var isLogin: Boolean
        get() = preferences.getBoolean(IS_USER_LOGIN.first, IS_USER_LOGIN.second)
        set(value) = preferences.edit {
            it.putBoolean(IS_USER_LOGIN.first, value)
        }

    var userData: String
        get() = preferences.getString(USER_DATA.first, USER_DATA.second)
        set(value) = preferences.edit {
            it.putString(USER_DATA.first, value)
        }
}
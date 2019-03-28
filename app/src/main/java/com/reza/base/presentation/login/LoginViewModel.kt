package com.reza.base.presentation.login

import androidx.databinding.ObservableField
import com.reza.base.core.BaseViewModel


/**
 * Created by Reza Kurniawan on 27/03/2019.
 */

class LoginViewModel : BaseViewModel() {
    val bShowLoadingView = ObservableField<Boolean>(false)
    val isLogin = ObservableField<Boolean>(false)
    val bTextEmail = ObservableField<String>()
    val bTextPassword = ObservableField<String>()
    val bTextEmailError = ObservableField<String>()
    val bTextPasswordError = ObservableField<String>()
}
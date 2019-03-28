package com.reza.base.presentation.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import com.reza.base.R
import com.reza.base.core.BaseActivity
import com.reza.base.core.ViewDataBindingOwner
import com.reza.base.databinding.ActivityLoginBinding
import com.reza.base.presentation.dashboard.DashboardActivity
import com.reza.base.util.PrefManager


/**
 * Created by Reza Kurniawan on 27/03/2019.
 */

class LoginActivity : BaseActivity(),
    LoginView,
    ViewDataBindingOwner<ActivityLoginBinding> {

    companion object {
        fun startThisActivity(context: Context) {
            val intent = Intent(context, LoginActivity::class.java)
            context.startActivity(intent)
        }
    }

    private lateinit var viewModel: LoginViewModel
    override lateinit var binding: ActivityLoginBinding

    override fun getViewLayoutResId(): Int {
        return R.layout.activity_login
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = LoginViewModel()
        viewModel = binding.vm!!

        title = "Login"
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(false)
            it.setHomeButtonEnabled(false)
        }
    }

    override fun onClickLogin(view: View) {
        if (validateFields()) {
            viewModel.bShowLoadingView.set(true)

            val emailPref = viewModel.bTextEmail.get()
            PrefManager.isLogin = true
            PrefManager.userData = emailPref!!
            DashboardActivity.startThisActivity(this@LoginActivity)
            finish()
        }
    }

    private fun validateFields(): Boolean {
        var isValid = true

        viewModel.bTextEmailError.set(null)
        viewModel.bTextPasswordError.set(null)

        if (viewModel.bTextEmail.get().isNullOrEmpty()) {
            isValid = false
            viewModel.bTextEmailError.set("Email tidak boleh kosong")
        } else if (!Patterns.EMAIL_ADDRESS.matcher(viewModel.bTextEmail.get()).matches()) {
            isValid = false
            viewModel.bTextEmailError.set("Format email yang anda masukkan salah")
        }

        if (viewModel.bTextPassword.get().isNullOrEmpty()) {
            isValid = false
            viewModel.bTextPasswordError.set("Password tidak boleh kosong")
        }

        return isValid
    }
}
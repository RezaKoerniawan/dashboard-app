package com.reza.base.presentation.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.reza.base.R
import com.reza.base.core.BaseFragment
import com.reza.base.core.ViewDataBindingOwner
import com.reza.base.databinding.FragmentProfileBinding
import com.reza.base.presentation.dashboard.DashboardActivity
import com.reza.base.presentation.login.LoginActivity
import com.reza.base.util.PrefManager


/**
 * Created by Reza Kurniawan on 27/03/2019.
 */

class ProfileFragment : BaseFragment(),
        ProfileView,
        ViewDataBindingOwner<FragmentProfileBinding> {

    override lateinit var binding: FragmentProfileBinding
    private lateinit var viewModel: ProfileViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as DashboardActivity).setActionBarTitle(getString(R.string.profile_title))
        binding.view = this
        binding.vm = ProfileViewModel()
        viewModel = binding.vm!!

        setProfileData()
    }

    private fun setProfileData() {
        PrefManager.userData.let {
            viewModel.bTextEmail.set(it)
        }
        //Hardcoded sex and phone
        viewModel.bTextSex.set(getString(R.string.profile_sex))
        viewModel.bTextPhone.set(getString(R.string.profile_phone))
    }

    override fun onClickLogout(view: View) {
        PrefManager.isLogin = false
        PrefManager.userData = ""
        LoginActivity.startThisActivity(context!!)
        (activity as DashboardActivity).finish()
    }
}
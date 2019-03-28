package com.reza.base.presentation.profile

import androidx.databinding.ObservableField
import com.reza.base.core.BaseViewModel


/**
 * Created by Reza Kurniawan on 27/03/2019.
 */

class ProfileViewModel : BaseViewModel() {
    val bTextEmail = ObservableField<String>()
    val bTextSex = ObservableField<String>()
    val bTextPhone = ObservableField<String>()
}
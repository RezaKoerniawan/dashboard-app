package com.reza.base.presentation.homepage

import androidx.databinding.ObservableField
import com.reza.base.core.BaseViewModel


/**
 * Created by Reza Kurniawan on 27/03/2019.
 */

class HomePageViewModel : BaseViewModel() {
    var bIsLoading = ObservableField<Boolean>(true)
}
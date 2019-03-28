package com.reza.base.presentation.homepage.adapter

import androidx.databinding.ObservableField
import com.reza.base.core.BaseViewModel


/**
 * Created by Reza Kurniawan on 28/03/2019.
 */

class HomePageItemListViewModel : BaseViewModel() {
    var bTextTitle = ObservableField<String>()
    var bTextPrice = ObservableField<String>()
}
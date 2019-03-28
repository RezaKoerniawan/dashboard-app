package com.reza.base.core

/**
 * @author reza.kurniawan
 * @date 21-Nov-18
 */
interface ViewModelOwner<T : BaseViewModel> {
    val viewModel: T
}

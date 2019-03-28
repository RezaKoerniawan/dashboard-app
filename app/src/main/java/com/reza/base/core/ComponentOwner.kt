package com.reza.base.core

/**
 * @author reza.kurniawan
 * @date 10-Mar-2019
 *
 * ComponentProvider
 * Interface for single component provider to inject from
 */
interface ComponentOwner<T> {

    var binding: T

//    @Suppress("UNCHECKED_CAST")
//    fun <C : T> componentAs(classOfT: Class<C>): C = binding as C

//    fun buildComponent(): T
}

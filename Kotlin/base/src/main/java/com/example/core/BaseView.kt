package com.example.core

interface BaseView<T> {
//    fun getPresenter() : T
    val presenter: T //抽象属性
}
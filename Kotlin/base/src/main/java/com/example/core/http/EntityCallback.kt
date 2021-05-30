package com.example.core.http

/**
 * @author wangyou
 * @desc:
 * @date :2021/5/19
 */
interface EntityCallback<T> {
    fun onSuccess(entity: T)
    fun onFailure(message: String?)
}
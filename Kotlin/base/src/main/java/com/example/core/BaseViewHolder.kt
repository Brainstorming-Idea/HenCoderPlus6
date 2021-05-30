package com.example.core

import android.view.View
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView
import java.util.*

/**
 * @author wangyou
 * @desc:
 * @date :2021/5/23
 */
abstract class BaseViewHolder : RecyclerView.ViewHolder {
    constructor(itemView: View) : super(itemView)

    private val viewHashMap: MutableMap<Int, View> = HashMap()

    fun <T : View> getView(id: Int) : T? {
        var view = viewHashMap[id]
        if (view == null) {
            view = itemView.findViewById(id)
            viewHashMap[id] = view
        }
        return (view as T?)
    }
    protected open fun setText(@IdRes id: Int, text: String?) {
        getView<TextView>(id)?.text = text
    }
}
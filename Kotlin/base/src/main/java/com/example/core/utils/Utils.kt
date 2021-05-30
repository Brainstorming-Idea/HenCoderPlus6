package com.example.core.utils

import android.content.res.Resources
import android.util.DisplayMetrics
import android.util.TypedValue
import android.widget.Toast
import com.example.core.BaseApplication

/**
 * @author wangyou
 * @desc:
 * @date :2021/5/19
 */
object Utils {
    private val displayMetrics:DisplayMetrics = Resources.getSystem().displayMetrics

    fun Float.dp2px() : Float
    = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,this, displayMetrics)

    fun toastShort(string: String){
        toast(string, Toast.LENGTH_SHORT)
    }

    fun toast(string:String, duration:Int)
    = Toast.makeText(BaseApplication.currentApplication(), string, duration).show()

}
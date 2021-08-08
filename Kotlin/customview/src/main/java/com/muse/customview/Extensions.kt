package com.muse.customview

import android.content.res.Resources
import android.util.TypedValue

/**
 * @author wangyou
 * @desc: 扩展属性
 * @date :2021/8/8
 */

//dp转px
val Float.px
    get() = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, Resources.getSystem().displayMetrics)

val Int.px
    get() = this.toFloat().px
package com.muse.customview

import android.content.res.Resources
import android.util.TypedValue

/**
 * @author wangyou
 * @desc:
 * @date :2021/8/8
 */
fun dp2px(dp:Float) : Float{
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dp, Resources.getSystem().displayMetrics)
}
class ViewUtils {

}
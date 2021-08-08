package com.muse.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import androidx.core.graphics.red

/**
 * @author wangyou
 * @desc:
 * @date :2021/8/8
 */
var radius = 100.px
class TestView(context: Context?, attr:AttributeSet?) : View(context, attr) {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)//抗锯齿
    var path = Path()
    /*view尺寸改变的时候回调*/
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        paint.color = Color.RED
        path.reset()//
        path.addRect(width/2f - radius, height/2f - radius, width/2f + radius, height/2f + radius,Path.Direction.CW)
        path.addCircle(width/2f, height/2f, radius, Path.Direction.CW)
        path.fillType = Path.FillType.INVERSE_EVEN_ODD//镂空
    }
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
//        canvas.drawCircle(width / 2f, height / 2f, radius,paint)
        canvas.drawPath(path,paint)
    }
}
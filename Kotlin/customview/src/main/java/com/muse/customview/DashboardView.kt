package com.muse.customview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

var ANGLE = 120f
var DASH_WIDTH = 3.px
var DASH_LENGTH = 5.px
class DashboardView(context:Context, attr:AttributeSet) : View(context, attr) {
    private var arcPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var dashPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var arcPath = Path()
    private var dashPath = Path()
    init {
        arcPaint.strokeWidth = 3.px
        arcPaint.style = Paint.Style.STROKE
        dashPath.addRect(0f,0f, DASH_WIDTH, DASH_LENGTH,Path.Direction.CCW)
        dashPaint.pathEffect = PathDashPathEffect(dashPath,50.px,0f,PathDashPathEffect.Style.MORPH)
    }
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        arcPaint.reset()
        arcPath.addArc(width/2f -150.px, height/2f - 150.px, width/2f + 150.px, height/2f + 150.px, ANGLE/2f + 90,360 - ANGLE)

    }
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
//        canvas.drawArc(width/2f -150.px, height/2f - 150.px, width/2f + 150.px, height/2f + 150.px, ANGLE/2f + 90,360 - ANGLE,false,paint)
        canvas.drawPath(arcPath, arcPaint)
        canvas.drawPath(dashPath, dashPaint)
    }

}
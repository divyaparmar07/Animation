package com.example.animation

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class CustomView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private val linePaint: Paint = Paint()
    private var xStart = 0f
    private var xEnd = 0f
    private var yStart = 0f
    private var yEnd = 0f

    init {
        linePaint.color = 0xFF0000FF.toInt() // Blue color
        linePaint.strokeWidth = 5f
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawLine(xStart, yStart, xEnd, yEnd, linePaint)
    }

//    fun drawLine(startX: Float, startY: Float, endX: Float, endY: Float) {
//        xStart = startX
//        yStart = startY
//        xEnd = endX
//        yEnd = endY
//        invalidate() // Redraw the view to show the line
//    }
}

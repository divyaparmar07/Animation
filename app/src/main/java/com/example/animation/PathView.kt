package com.example.animation

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class PathView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    private val path = Path()
    private val paint = Paint()

    init {
        paint.color = Color.RED
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 8f
        path.moveTo(0f, 0f)
        path.quadTo(
            context.resources.displayMetrics.widthPixels / 2f,
            -300f,
            context.resources.displayMetrics.widthPixels.toFloat(),
            0f
        )
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val paint = Paint()
        paint.color = Color.RED
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 5f
        canvas.drawPath(path, paint)
    }

    fun setPath(newPath: Path) {
        path.reset()
        path.addPath(newPath)
        invalidate()
    }
}
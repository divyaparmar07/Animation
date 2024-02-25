package com.example.animation

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.graphics.Path
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.animation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        val ball: View = mainBinding.ball
        val pathView = mainBinding.pathView

        ballBouncing(ball, pathView)
    }

    private fun ballBouncing(ball: View, pathView: PathView) {
        val path = Path()

        // Create an ObjectAnimator for the X-axis (horizontal) movement
        val bounceAnimator = ObjectAnimator.ofFloat(
            ball,
            "translationX",
            0f, // Start position (left)
            resources.displayMetrics.widthPixels - ball.width.toFloat() // End position (right)
        )

        //sets the duration of the animation to 2000 milliseconds (2 seconds)
        bounceAnimator.duration = 6000

        // Create a ValueAnimator for the bounce height
        val bounceHeightAnimator = ValueAnimator.ofFloat(0f, 350f)
        bounceHeightAnimator.duration = 500 // Ball bounce speed
        bounceHeightAnimator.repeatMode = ValueAnimator.REVERSE
        bounceHeightAnimator.repeatCount = ValueAnimator.INFINITE

        bounceHeightAnimator.addUpdateListener { animation ->
            val value = animation.animatedValue as Float
            ball.translationY = value

            // Update the path with the new position of the ball
            path.lineTo(ball.x, value)
            pathView.setPath(path)
        }

        // Initialize the path with the starting position of the ball
        path.moveTo(ball.x + ball.x / 2, 0f)
        pathView.setPath(path)

        // Create an AnimatorSet to combine the horizontal and vertical animations
        val animatorSet = AnimatorSet()
        animatorSet.playTogether(bounceAnimator, bounceHeightAnimator)

        // Start the animation
        animatorSet.start()
    }
}
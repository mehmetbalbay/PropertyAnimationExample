package com.mehmetbalbay.propertyanimationexample

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    lateinit var androidImage: ImageView
    lateinit var rotateBtn: Button
    lateinit var translateButton: Button
    lateinit var scaleButton: Button
    lateinit var fadeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        androidImage = findViewById(R.id.android_image)
        rotateBtn = findViewById(R.id.rotate)
        translateButton = findViewById(R.id.translate)
        scaleButton = findViewById(R.id.scale)
        fadeButton = findViewById(R.id.fade)

        rotateBtn.setOnClickListener {
            rotateImage();
        }

        scaleButton.setOnClickListener {
            scaleImage()
        }

        fadeButton.setOnClickListener {
            fadeImage()
        }

        translateButton.setOnClickListener {
            translateImage()
        }
    }

    private fun rotateImage() {
        val animator = ObjectAnimator.ofFloat(androidImage, View.ROTATION, -360f, 0f)
        animator.duration = 1500
        animator.disableViewDuringAnimation(rotateBtn)
        animator.start()
    }

    private fun translateImage() {
        val animator = ObjectAnimator.ofFloat(androidImage, View.TRANSLATION_X, 150f)
        animator.repeatCount = 2
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.disableViewDuringAnimation(translateButton)
        animator.start()
    }

    private fun scaleImage() {
        val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 5f)
        val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 5f)
        val animator = ObjectAnimator.ofPropertyValuesHolder(androidImage, scaleX, scaleY)
        animator.repeatCount = 1
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.disableViewDuringAnimation(scaleButton)
        animator.start()
    }

    private fun fadeImage() {
        val animator = ObjectAnimator.ofFloat(androidImage, View.ALPHA, 0f)
        animator.repeatCount = 1
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.disableViewDuringAnimation(fadeButton)
        animator.start()
    }

    private fun ObjectAnimator.disableViewDuringAnimation(view: View) {

        addListener(object: AnimatorListenerAdapter() {

            override fun onAnimationStart(animation: Animator?) {
                view.isEnabled = false
            }

            override fun onAnimationEnd(animation: Animator?) {
                view.isEnabled = true
            }

        })
    }
}
package com.example.mad_practical_9_21012011103

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView

class SplashActivity : AppCompatActivity(), Animation.AnimationListener {

    lateinit var logoImage: ImageView
    lateinit var logoAnimation: Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        logoImage = findViewById<ImageView>(R.id.logoGUNI)
        logoImage.setBackgroundResource(R.drawable.guni_animation_list)
        logoAnimation = AnimationUtils.loadAnimation(this, R.anim.twin_animation)
        logoAnimation.setAnimationListener(this)

    }

    override fun onAnimationStart(p0: Animation?) {
        logoAnimation.start()
    }

    override fun onAnimationEnd(p0: Animation?) {
        
    }

    override fun onAnimationRepeat(p0: Animation?) {
    }
}
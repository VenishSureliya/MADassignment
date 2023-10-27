package com.example.mad_practical_9_21012011103

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    lateinit var alarmAnimationDrawable: AnimationDrawable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imagealarm=findViewById<ImageView>(R.id.imageView)
        imagealarm.setBackgroundResource(R.drawable.alarm_animaton_list)
        alarmAnimationDrawable=imagealarm.background as AnimationDrawable



    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        if (hasFocus){
            alarmAnimationDrawable.start()
        }
        else{
            alarmAnimationDrawable.stop()
        }
        super.onWindowFocusChanged(hasFocus)
    }

}
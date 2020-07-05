package com.linmh.rainbow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*

class LaunchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)
        val timer=Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                val intent=Intent(this@LaunchActivity,MainActivity::class.java)
                startActivity(intent)
            }
        },10)
    }

}
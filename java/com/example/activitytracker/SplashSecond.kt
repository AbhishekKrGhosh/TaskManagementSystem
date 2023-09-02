package com.example.activitytracker

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.TextView

class SplashSecond : AppCompatActivity() {

    lateinit var handler: Handler
    private lateinit var sharedPreferences: SharedPreferences
    lateinit var name : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_second)
        supportActionBar?.hide()
        name = findViewById(R.id.name)
        sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
        val storedUsername = sharedPreferences.getString("username", "")
        name.text = storedUsername
        handler = Handler()
        handler.postDelayed({

            val i = Intent(this, NavigationDrawer::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }, 700)
    }
}
package com.example.activitytracker

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreenActivity : AppCompatActivity() {

    lateinit var handler: Handler
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        supportActionBar?.hide()
        sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
        val storedUsername = sharedPreferences.getString("username", "")

        handler = Handler()
        handler.postDelayed({
            if(storedUsername == ""){
                val i = Intent(this, SignUp::class.java)
                startActivity(i)
            }
            else{
                val j = Intent(this, Login::class.java)
                startActivity(j)
            }
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }, 1500)
    }
}
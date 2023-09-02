package com.example.activitytracker

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class Login : AppCompatActivity() {


    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: ImageButton
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        passwordEditText = findViewById(R.id.password)
        loginButton = findViewById(R.id.next)

        sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)

        loginButton.setOnClickListener {

            val password = passwordEditText.text.toString()


            val storedPassword = sharedPreferences.getString("password", "")

            if (password == storedPassword) {
                Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, SplashSecond::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Invalid credentials!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
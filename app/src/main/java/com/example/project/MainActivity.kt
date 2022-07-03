package com.example.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val login = findViewById<Button>(R.id.login)
        val reset = findViewById<Button>(R.id.reset)
        val user = findViewById<TextView>(R.id.user)
        val password = findViewById<TextView>(R.id.password)

        login.setOnClickListener {
            Toast.makeText(this, "Your username is ${user.text} and password is ${password.text}", Toast.LENGTH_LONG).show()
        }
        reset.setOnClickListener {
            user.text = ""
            password.text = ""
            Toast.makeText(this, "Cleared", Toast.LENGTH_SHORT).show()
        }
    }
}
package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val start: Button = findViewById(R.id.start)
        var name: EditText = findViewById(R.id.name)

        start.setOnClickListener{
            if (name.text.isNotEmpty()) {
                val intention = Intent(this, MainActivity2::class.java)
                intent.putExtra(Constants.USERNAME, name.text.toString())
                startActivity(intention)
                finish()

            } else {
                Toast.makeText(this, "Enter a username", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
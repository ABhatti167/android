package com.example.myapplication1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var c = 0
        val count = findViewById<TextView>(R.id.textView3)
        count.textSize = 0F
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener() {

            c++
            count.textSize = c.toFloat()
            count.text = c.toString()
            Toast.makeText(this, c.toString(), Toast.LENGTH_SHORT).show()
        }
    }

}
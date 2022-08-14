package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val username: TextView = findViewById(R.id.congrats)
        val score: TextView = findViewById(R.id.score)
        val finish: Button = findViewById(R.id.finish)




        val username2 = intent.getStringExtra(Constants.USERNAME)
        val questions = intent.getIntExtra(Constants.TOTAL, 0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)

        username.text = "Congratulations $username2"
        score.text = "your score was $correctAnswers out of $questions"

        finish.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
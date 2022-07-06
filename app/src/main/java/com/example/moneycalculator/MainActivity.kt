package com.example.moneycalculator

import android.animation.ArgbEvaluator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.*
import androidx.core.content.ContextCompat
import java.util.*

private const val c = "MainActivity"
private const val i = 15
class MainActivity : AppCompatActivity() {
    private lateinit var base: EditText
    private lateinit var scroll: SeekBar
    private lateinit var percent: TextView
    private lateinit var feedback: TextView
    private lateinit var tips: TextView
    private lateinit var totals: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        base = findViewById(R.id.texts)
        scroll = findViewById(R.id.scroll)
        percent = findViewById(R.id.textView2)
        feedback = findViewById(R.id.textView5)
        tips = findViewById(R.id.textView6)
        totals = findViewById(R.id.textView7)



        scroll.progress = i
        percent.text = "${scroll.progress}%"
        scroll.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, progress: Int, user: Boolean) {

                percent.text = "$progress%"
                feedbackchange(progress)
                change()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })

        base.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                change()
            }

        })
    }

    private fun feedbackchange(progress: Int) {
        if (progress >= 50 && progress <= 100) {
            feedback.text = "That is a huge amount"

        } else if (progress >= 20 && progress <= 49) {
            feedback.text = "That is big"
        } else if (progress <= 19 && progress != 0) {
            feedback.text = "That is moderatge"
        }  else if (progress == 0) {
            feedback.text = "That is nothing"

        }
        val color = ArgbEvaluator().evaluate(
            progress.toFloat() / 100F,
            ContextCompat.getColor(this, R.color.red),
            ContextCompat.getColor(this, R.color.green)
        ) as Int
        feedback.setTextColor(color)
    }
    private fun change() {

        if (base.text.isEmpty()) {
            tips.text = "";
            totals.text = "";
            return
        }



        var base = base.text.toString().toDouble()
        val percent = scroll.progress

        val tip = base * percent/100

        val total = base + tip

        tips.text = "%.2f".format(tip)
        totals.text = "%.2f".format(total)
    }
}
package com.example.myapplication

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

   private var text : TextView? = null

    private var text2 : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button : Button = findViewById(R.id.button2)
        text = findViewById(R.id.textView4)
        text2 = findViewById(R.id.textView6)

        button.setOnClickListener{
            date()
        }
    }

    private fun date() {
        val calender = Calendar.getInstance()
        val year = calender.get(Calendar.YEAR)
        val month = calender.get(Calendar.MONTH)
        val day = calender.get(Calendar.DAY_OF_MONTH)

        val calculation = DatePickerDialog(this,
            {view, year, month, day ->
                val born = "$day/${month+1}/$year"
                text?.setText(born)

                val f = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

                val dates = f.parse(born)
                dates?.let {
                    val minutes = dates.time / 60000

                    val current = f.parse(f.format(System.currentTimeMillis()))
                    current?.let {
                        val currentMinutes = current.time / 60000

                        val diff = currentMinutes - minutes

                        text2?.text = "$diff"
                    }

                }


                    Toast.makeText(this, "Works", Toast.LENGTH_SHORT).show()
            },
            year,
            month,
            day
        )

        calculation.datePicker.maxDate = System.currentTimeMillis() - 86400000

        calculation.show()

    }



}
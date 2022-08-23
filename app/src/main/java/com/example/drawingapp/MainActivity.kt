package com.example.drawingapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.get

class MainActivity : AppCompatActivity() {

    private var draw: DrawingView? = null

    private var mColorButton: ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        draw = findViewById(R.id.drawingview)



        draw?.sizepicker(20F)

        val linearLayoutcolors = findViewById<LinearLayout>(R.id.colors)

        mColorButton = linearLayoutcolors[1] as ImageButton

        mColorButton!!.setImageDrawable(
            ContextCompat.getDrawable(this, R.drawable.palletpressed)
        )

        val brushes: ImageButton = findViewById(R.id.sizepickerdialog)
        brushes.setOnClickListener() {
            showBrushSize()
        }

    }

    private fun showBrushSize() {
        val brushDialog = Dialog(this)
        brushDialog.setContentView(R.layout.brush_size)
        brushDialog.setTitle("Brush size :")
        val smallBtn: ImageButton = brushDialog.findViewById(R.id.small)
        smallBtn.setOnClickListener() {
            draw?.sizepicker(10F)
            brushDialog.dismiss()
        }
        val mediumBtn: ImageButton = brushDialog.findViewById(R.id.medium)
        mediumBtn.setOnClickListener(){
            draw?.sizepicker(20F)
            brushDialog.dismiss()
        }
        val largeBtn: ImageButton = brushDialog.findViewById(R.id.large)
        largeBtn.setOnClickListener(){
            draw?.sizepicker(30F)
            brushDialog.dismiss()
        }
        brushDialog.show()
    }

    fun paintClicked(view: View) {

        if (view !== mColorButton ) {
            val imagebutton = view as ImageButton
            val color = imagebutton.tag.toString()

            draw?.setColor(color)
            imagebutton.setImageDrawable(
                ContextCompat.getDrawable(this, R.drawable.palletpressed)
            )

            mColorButton!!.setImageDrawable(
                ContextCompat.getDrawable(this, R.drawable.palletnormal)
            )

            mColorButton = view
        }
    }
}
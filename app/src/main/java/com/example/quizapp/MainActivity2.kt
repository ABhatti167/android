package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import java.util.ArrayList

class MainActivity2 : AppCompatActivity(), View.OnClickListener{

    private var position: Int = 1

    private var questionslist: ArrayList<Question>?= null

    private var selected: Int = 0

    private var progress: ProgressBar? = null
    private var tvprogress: TextView? = null
    private var tvquestion: TextView? = null
    private var image: ImageView? = null

    private var mUsername: String? = null
    private var mCorrectAnswers: Int = 0

    private var One: TextView? = null
    private var Two: TextView? = null
    private var Three: TextView? = null
    private var Four: TextView? = null

    private var submitbutton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        mUsername = intent.getStringExtra(Constants.USERNAME)

        tvquestion = findViewById(R.id.display)
        progress = findViewById(R.id.progressBar)
        tvprogress = findViewById(R.id.progress)
        image = findViewById(R.id.imagedisplay)

        One = findViewById(R.id.o1)
        Two = findViewById(R.id.o2)
        Three = findViewById(R.id.o3)
        Four = findViewById(R.id.o4)

        submitbutton = findViewById(R.id.submit)

        questionslist = Constants.getQuestions()

        setQuestion()

        default()

        One?.setOnClickListener(this)
        Two?.setOnClickListener(this)
        Three?.setOnClickListener(this)
        Four?.setOnClickListener(this)
        submitbutton?.setOnClickListener(this)
    }

    private fun setQuestion() {

        val question: Question = questionslist!![position-1]

        progress?.progress = position
        tvprogress?.text = "${position}/9"
        tvquestion?.text = question.questions
        image?.setImageResource(question.image)

        One?.text = question.optionOne
        Two?.text = question.optionTwo
        Three?.text = question.optionThree
        Four?.text = question.optionFour


    }

    private fun default() {

        submitbutton?.text = "SUBMIT"
        val options = ArrayList<TextView>()
        One?.let{
            options.add(0, it)
        }

        Two?.let{
            options.add(1, it)
        }
        Three?.let{
            options.add(2, it)
        }
        Four?.let{
            options.add(3, it)
        }

        for (o in options) {
            o.setTextColor(Color.BLACK)

            o.typeface = Typeface.DEFAULT

            o.background = ContextCompat.getDrawable(this, R.drawable.ic_drawable)
        }
    }

    private fun selected(tv: TextView, num: Int) {
        default()
        tv.setTextColor(Color.BLACK)


        tv.setTypeface(tv.typeface,Typeface.BOLD)

        selected = num
        tv.background = ContextCompat.getDrawable(this, R.drawable.ic_selection)
    }


    override fun onClick(view: View?) {

        when (view?.id) {
            R.id.o1 -> {
                One?.let {
                    selected(it, 1)
                }
            }
            R.id.o2 -> {
                Two?.let {
                    selected(it, 2)
                }
            }
            R.id.o3 -> {
                Three?.let {
                    selected(it, 3)
                }
            }
            R.id.o4 -> {
                Four?.let {
                    selected(it, 4)
                }
            }
            R.id.submit -> {
                submitbutton?.let {
                    if (selected == 0) {
                        if (position < 10)
                            position++

                        when{
                            position <= (questionslist!!.size) -> {
                                setQuestion()
                            }
                            else -> {
                                val intention2 = Intent(this, ResultActivity::class.java)
                                intention2.putExtra(Constants.USERNAME, mUsername)
                                intention2.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                                intention2.putExtra(Constants.TOTAL, questionslist!!.size)
                                startActivity(intention2)
                                finish()
                            }
                        }
                        default()
                    } else {
                        val question = questionslist?.get(position - 1)

                        if (question!!.correct != selected) {
                            answerview(selected, R.drawable.ic_wrong)
                        } else {
                            mCorrectAnswers++
                        }

                        answerview(question!!.correct, R.drawable.ic_correct)

                        selected = 0


                        if (position == questionslist?.size) {
                            submitbutton?.text = "FINISHED"
                        } else
                            submitbutton?.text = "Next Question?"
                    }
                }
            }
        }
    }

    private fun answerview(answer: Int, bg: Int) {
        when (answer) {
            1 -> {
                One?.background = ContextCompat.getDrawable(this, bg)
            }
            2 -> {
                Two?.background = ContextCompat.getDrawable(this@MainActivity2, bg)
            }
            3 -> {
                Three?.background = ContextCompat.getDrawable(this@MainActivity2, bg)
            }
            4 -> {
                Four?.background = ContextCompat.getDrawable(this@MainActivity2, bg)
            }
        }
    }
}
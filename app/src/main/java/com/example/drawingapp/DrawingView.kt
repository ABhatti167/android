package com.example.drawingapp

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.TypedValue
import android.view.MotionEvent
import android.view.View

class DrawingView(context: Context, attributes: AttributeSet) : View(context, attributes) {

    private var mPath: CustomPath? = null
    private var mCanvasBitmap: Bitmap? = null
    private var mPaint: Paint? = null

    private var mCanvasPaint: Paint? = null
    private var mBrushSize: Float = 10F

    private var color = Color.BLACK

    private var canvas: Canvas? = null

    private val mPaths = ArrayList<CustomPath>()

    init{
        setUpDrawing()
    }

    private fun setUpDrawing() {
        mPaint = Paint()
        mPath = mBrushSize?.let { CustomPath(color, it) }
        mPaint!!.color = color
        mPaint!!.style = Paint.Style.STROKE
        mPaint!!.strokeJoin = Paint.Join.ROUND
        mPaint!!.strokeCap = Paint.Cap.ROUND
        mCanvasPaint = Paint(Paint.DITHER_FLAG)

        mBrushSize = 20F
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val touchX = event?.x
        val touchY = event?.y

        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                mPath!!.color = color
                mPath!!.thickness = mBrushSize

                mPath!!.reset()
                if (touchX != null) {
                    if (touchY != null) {
                        mPath!!.moveTo(touchX, touchY)

                    }
                }
            }
            MotionEvent.ACTION_MOVE -> {
                if (touchX != null) {
                    if (touchY != null) {
                        mPath!!.lineTo(touchX, touchY)
                    }
                }


            }
            MotionEvent.ACTION_UP -> {
                mPaths.add(mPath!!)

                mPath = CustomPath(color, mBrushSize)



            }
            else -> return false
        }
        invalidate()


        return true
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mCanvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
            canvas = Canvas(mCanvasBitmap!!)

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawBitmap(mCanvasBitmap!!, 0f, 0f, mCanvasPaint)


        for (path in mPaths) {
            mPaint!!.strokeWidth = path!!.thickness
            mPaint!!.color = path!!.color
            canvas?.drawPath(path!!, mPaint!!)
        }

        if (!mPath!!.isEmpty) {
            mPaint!!.strokeWidth = mPath!!.thickness
            mPaint!!.color = mPath!!.color
            canvas?.drawPath(mPath!!, mPaint!!)

        }

    }

    fun sizepicker(newSize: Float) {
        mBrushSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, newSize, resources.displayMetrics)
        mPaint!!.strokeWidth = mBrushSize

    }


    fun setColor(newColor: String) {
        color = Color.parseColor(newColor)
        mPaint!!.color = color
    }
    internal inner class CustomPath(var color: Int, var thickness: Float) : Path() {

    }

}
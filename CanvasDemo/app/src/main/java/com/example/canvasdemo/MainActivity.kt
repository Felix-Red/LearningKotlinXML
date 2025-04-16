package com.example.canvasdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import android.app.Activity
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.widget.ImageView
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.canvasdemo.ui.theme.CanvasDemoTheme

class MainActivity : Activity() {

    //classes that we need to do some drawing

    lateinit var myImageView: ImageView
    lateinit var myBlankBitmap: Bitmap
    lateinit var myCanvas: Canvas
    lateinit var myPaint: Paint

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val widthInPixels = 800
        val heightInPixels = 600

        //create a new Bitmap
        myBlankBitmap = Bitmap.createBitmap(widthInPixels, heightInPixels, Bitmap.Config.ARGB_8888)

        myCanvas = Canvas(myBlankBitmap)

        myImageView = ImageView(this)
        myPaint = Paint()

        myCanvas.drawColor(Color.argb(255, 0, 0, 255))

        myPaint.textSize = 110f

        myPaint.color =Color.argb(255,255,255,255)
        myCanvas.drawText("Hello World!", 100f, 100f, myPaint)

        myPaint.color = Color.argb(255, 212, 207, 62)

        myCanvas.drawCircle(400f, 250f, 100f, myPaint)

        myImageView.setImageBitmap(myBlankBitmap)
        setContentView(myImageView)
    }
}


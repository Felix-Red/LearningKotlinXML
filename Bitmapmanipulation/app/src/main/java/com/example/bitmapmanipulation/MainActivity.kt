package com.example.bitmapmanipulation

import android.os.Bundle
import androidx.activity.ComponentActivity
import android.app.Activity
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.widget.ImageView
import android.graphics.Matrix
import android.graphics.BitmapFactory
import android.graphics.Color
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bitmapmanipulation.ui.theme.BitmapManipulationTheme

class MainActivity : Activity() {
    lateinit var myImageView: ImageView
    lateinit var myBlankBitmap: Bitmap
    lateinit var bobBitmap: Bitmap
    lateinit var myCanvas: Canvas
    lateinit var myPaint: Paint

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val widthInPixels = 2000
        val heightInPixels = 1000

        myBlankBitmap = Bitmap.createBitmap(widthInPixels, heightInPixels, Bitmap.Config.ARGB_8888)

        bobBitmap = BitmapFactory.decodeResource(resources, R.drawable.bob)

        myCanvas = Canvas(myBlankBitmap)

        myImageView = ImageView(this)

        myPaint = Paint()

        myCanvas.drawColor(Color.argb(255, 0, 0, 255))

        drawRotatedBitmaps()
        drawEnlargedBitmap()
        drawShrunkenBitmap()

        // Associate the drawn upon Bitmap
        // with the ImageView
        myImageView.setImageBitmap(myBlankBitmap)
        // Tell Android to set our drawing
        // as the view for this app
        // via the ImageView
        setContentView(myImageView)

    }
    fun drawRotatedBitmaps(){
        var rotation = 0f
        var horizontalPosition = 350
        var verticalPosition = 25
        val matrix = Matrix()

        var rotatedBitmap: Bitmap

        rotation = 0f

        while(rotation < 360){
            matrix.reset()
            matrix.preRotate(rotation)
            rotatedBitmap = Bitmap.createBitmap(bobBitmap, 0, 0, bobBitmap.width - 1, bobBitmap.height -1, matrix, true )

            myCanvas.drawBitmap(rotatedBitmap, horizontalPosition.toFloat(), verticalPosition.toFloat(), myPaint)

            horizontalPosition += 120
            verticalPosition += 70
            rotation += 30f
        }
    }

    fun drawEnlargedBitmap(){
        bobBitmap = Bitmap.createScaledBitmap(bobBitmap, 300, 400, false)

        myCanvas.drawBitmap(bobBitmap, 25f, 25f, myPaint)

    }

    fun drawShrunkenBitmap(){
        bobBitmap = Bitmap.createScaledBitmap(bobBitmap,50, 75, false)
        myCanvas.drawBitmap(bobBitmap, 250f, 25f, myPaint)
    }
}


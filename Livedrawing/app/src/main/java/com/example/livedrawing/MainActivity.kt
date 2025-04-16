package com.example.livedrawing

import android.os.Bundle
import androidx.activity.ComponentActivity
import android.app.Activity
import android.graphics.Point
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.livedrawing.ui.theme.LiveDrawingTheme

class MainActivity : Activity() {
    private lateinit var liveDrawingView: LiveDrawingView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val display = windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)

        liveDrawingView = LiveDrawingView(this, size.x)

        setContentView(liveDrawingView)


    }

    override fun onResume() {
        super.onResume()

        liveDrawingView.resume()
    }

    override fun onPause() {
        super.onPause()
        liveDrawingView.pause()
    }
}


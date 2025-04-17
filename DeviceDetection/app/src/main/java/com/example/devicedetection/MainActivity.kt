package com.example.devicedetection

import android.graphics.Point
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.devicedetection.ui.theme.DeviceDetectionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
    }
    fun detectDevice(v: View) {
        val txtOrientation = findViewById<TextView>(R.id.txtOrientation)
        val txtResolution = findViewById<TextView>(R.id.txtResolution)

        val display = windowManager.defaultDisplay
        txtOrientation.text = "${display.rotation}"

        val xy = Point()
        display.getSize(xy)
        txtResolution.text = "x = ${xy.x} y = ${xy.y}"
    }
}


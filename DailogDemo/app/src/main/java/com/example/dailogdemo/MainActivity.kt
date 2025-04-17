package com.example.dailogdemo

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity // Changed from ComponentActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            val myDialog = MyDialog()
            myDialog.show(supportFragmentManager, "123")
        }
    }
}


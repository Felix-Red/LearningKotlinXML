package com.example.simplefragment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.example.simplefragment.ui.theme.SimpleFragmentTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create a new fragment using the manager
        var frag = supportFragmentManager
            .findFragmentById(R.id.fragmentHolder)

            // Check the fragment has not already been initialized
        if (frag == null) {
            // Initialize the fragment based on our SimpleFragment
            frag = SimpleFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentHolder, frag)
                .commit()
        }
    }
}


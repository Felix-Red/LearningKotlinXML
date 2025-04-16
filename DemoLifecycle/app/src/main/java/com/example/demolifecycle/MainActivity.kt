package com.example.demolifecycle

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.demolifecycle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        Toast.makeText(this, "In onCreate()", Toast.LENGTH_SHORT).show()
        Log.i("Info", "in onCreate()")


    }

    override fun onStart() {
        //Calling the original version of this function
        super.onStart()

        Toast.makeText(this, "In onStart", Toast.LENGTH_SHORT).show()

        Log.i("info", "in onStart")
    }

    override fun onResume() {
        super.onResume()

        Toast.makeText(this, "In onResume", Toast.LENGTH_SHORT).show()

        Log.i("Info", "in onResume")
    }

    override fun onPause() {
        super.onPause()

        Toast.makeText(this, "In onPause", Toast.LENGTH_SHORT).show()

        Log.i("Info", "in onPause")
    }

    override fun onStop() {
        super.onStop()

        Toast.makeText(this, "In onStop", Toast.LENGTH_SHORT).show()

        Log.i("Info", "in onStop")
    }

    override fun onDestroy() {
        super.onDestroy()

        Toast.makeText(this, "In onDestroy", Toast.LENGTH_SHORT).show()

        Log.i("Info", "in onDestroy")
    }



}
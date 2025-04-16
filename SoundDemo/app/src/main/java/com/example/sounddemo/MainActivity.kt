package com.example.sounddemo

import android.content.res.AssetFileDescriptor
import android.media.AudioAttributes
import android.media.SoundPool
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
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.SeekBar
import android.widget.Spinner
import com.example.sounddemo.databinding.ActivityMainBinding
import java.io.IOException

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var sp: SoundPool


    private var idFX1 = -1
    private var idFX2 = -1
    private var idFX3 = -1

    var nowPlaying = -1
    var volume = .1f
    var repeats = 2

    init{

        val audioAttributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.
            USAGE_ASSISTANCE_SONIFICATION)
            .setContentType(AudioAttributes.
            CONTENT_TYPE_SONIFICATION)
            .build()

        sp = SoundPool.Builder()
            .setMaxStreams(5)
            .setAudioAttributes(audioAttributes)
            .build()
    }

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        setContentView(R.layout.activity_main)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .setAnchorView(R.id.fab).show()
        }

        val btnFX1 = findViewById<Button>(R.id.btnFX1)
        val btnFX2 = findViewById<Button>(R.id.bntFX2)
        val btnFX3 = findViewById<Button>(R.id.btnFX3)
        val btnStop = findViewById<Button>(R.id.btnStop)

        btnFX1.setOnClickListener(this)
        btnFX2.setOnClickListener(this)
        btnFX3.setOnClickListener(this)
        btnStop.setOnClickListener(this)

        try{
            val assetManager = this.assets
            var descriptor: AssetFileDescriptor

            descriptor = assetManager.openFd("fx1.ogg")
            idFX1 = sp.load(descriptor, 0)

            descriptor = assetManager.openFd("fx2.ogg")
            idFX2 = sp.load(descriptor, 0)

            descriptor = assetManager.openFd("fx3.ogg")
            idFX3 = sp.load(descriptor, 0)

        }catch (e: IOException){
            Log.e("error", "failed to load sound files")
        }

        val seekBar = findViewById<SeekBar>(R.id.seekBar)

        seekBar.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener{
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    volume = progress /10f
                    sp.setVolume(nowPlaying, volume, volume)
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {

                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {

                }
            })

        val spinner = findViewById<Spinner>(R.id.spinner)

        spinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {

                override fun onItemSelected(
                    parentView: AdapterView<*>,
                    selectedItemView: View,
                    position: Int, id: Long) {

                    val temp = spinner.selectedItem.toString()
                    repeats = Integer.valueOf(temp)
                }

                override fun onNothingSelected(
                    parentView: AdapterView<*>) {
                }
            }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onClick(v: View?) {

        when(v?.id){
            R.id.btnFX1 -> {
                sp.stop(nowPlaying)
                nowPlaying = sp.play(idFX1, volume, volume, 0, repeats, 1f)
            }
            R.id.bntFX2 -> {
                sp.stop(nowPlaying)
                nowPlaying = sp.play(idFX2, volume, volume, 0, repeats, 1f)
            }
            R.id.btnFX3 -> {
                sp.stop(nowPlaying)
                nowPlaying = sp.play(idFX3, volume, volume, 0, repeats, 1f)
            }
            R.id.btnStop -> sp.stop(nowPlaying)
        }
    }


}
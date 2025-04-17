package com.example.widgerexploration

import android.os.Bundle
import androidx.activity.ComponentActivity
import android.graphics.Color
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.TextClock
import android.widget.TextView

//import kotlinx.android.synthetic.main.exploration_layout.*

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.exploration_layout)

        //Relative layout 2
        val checkBoxTransparency = findViewById<CheckBox>(R.id.checkBoxTranxparency)
        val imageView = findViewById<ImageView>(R.id.imageView)
        val checkBoxTint = findViewById<CheckBox>(R.id.checkBoxTint)
        val checkBoxResize = findViewById<CheckBox>(R.id.checkBoxResiz)

        checkBoxTransparency.setOnCheckedChangeListener({
            view, isChecked ->
                if(isChecked){
                    imageView.alpha = .1f

                }else{
                    imageView.alpha = 1f
                }
        })

        checkBoxTint.setOnCheckedChangeListener({
            view, isChecked ->
                if(isChecked){
                    imageView.setColorFilter(Color.argb(150, 255, 0, 0))
                }else{
                    imageView.setColorFilter(Color.argb(0, 0, 0, 0))
                }
        })

        checkBoxResize.setOnCheckedChangeListener({
            view, isChecked ->
                if(isChecked){
                    imageView.scaleX = 2f
                    imageView.scaleY = 2f
                } else {
                    // It's not checked make regular size
                    imageView.scaleX = 1f
                    imageView.scaleY = 1f
                }
        })

        //Relative layout 1

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val radioButtonLondon = findViewById<RadioButton>(R.id.radioButtonLondon)
        val radioButtonBeijing = findViewById<RadioButton>(R.id.radioButtonBeijing)
        val radioButtonNewYork = findViewById<RadioButton>(R.id.radioButtonNewYork)
        val radioButtonEuro = findViewById<RadioButton>(R.id.radioButtonEuropeanEmpire)

        val textClock = findViewById<TextClock>(R.id.textClock)

        radioGroup.clearCheck()

        radioGroup.setOnCheckedChangeListener{
            group, checkedId ->
            val rb = group.findViewById<RadioGroup>(R.id.radioGroup)

            when(rb.id){
                R.id.radioButtonLondon ->
                    textClock.timeZone = "Europe/London"
                R.id.radioButtonBeijing ->
                    textClock.timeZone = "CST6CDT"


                R.id.radioButtonNewYork ->
                    textClock.timeZone = "America/New_York"


                R.id.radioButtonEuropeanEmpire ->
                    textClock.timeZone = "Europe/Brussels"
            }
        }

        val button = findViewById<Button>(R.id.button)
        val editText = findViewById<EditText>(R.id.editText)
        val textView = findViewById<TextView>(R.id.textView)
        button.setOnClickListener {
            // it... accesses the view that was clicked

            // We want to act on the textView and editText instances
            // Change the text on the TextView
            // to whatever is currently in the EditText
            textView.text = editText.text
        }

        val switch1 = findViewById<Switch>(R.id.switch1)
        // Show or hide the TextView
        switch1.setOnCheckedChangeListener {
                buttonView, isChecked ->
            if (isChecked) {
                textView.visibility = View.VISIBLE
            } else {
                textView.visibility = View.INVISIBLE
            }
        }


    }
}


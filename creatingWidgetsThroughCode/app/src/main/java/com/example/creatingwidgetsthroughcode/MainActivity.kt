package com.example.creatingwidgetsthroughcode

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Switch
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.creatingwidgetsthroughcode.ui.theme.CreatingWidgetsThroughCodeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val linearLayout = LinearLayout(this)
        linearLayout.orientation = LinearLayout.VERTICAL
        val myButton = Button(this)
        myButton.text = "Click Me"

        val txtValue = TextView(this)
        txtValue.text = "Hide and Show"
        val mySwitch = Switch(this)
        mySwitch.setOnCheckedChangeListener{
            buttonView, isChecked ->
            if(isChecked){
                txtValue.visibility = View.INVISIBLE
            }else{
                txtValue.visibility = View.VISIBLE
            }
        }


        linearLayout.addView(myButton)
        linearLayout.addView(txtValue)
        linearLayout.addView(mySwitch)

        setContentView(linearLayout)

    }
}


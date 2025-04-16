package com.example.functions

import android.os.Bundle
import android.util.Log
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
import com.example.functions.ui.theme.FunctionsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        printSum(15, 17)
        orderProduct(product = "Iphone 16 plus", PostalService = "Ram")
    }

    fun printSum(a:Int, b:Int){
        Log.i("a + b = ", "${a + b}")
    }

    fun orderProduct(giftWrap: Boolean = false, product:String, PostalService: String ="Postage"){
        var details:String = ""
        if(giftWrap){
            details += "Gift wrapped"
        }

        details += "$product"
        details += "posted by $PostalService"
        Log.i("Order details", details)
    }
}


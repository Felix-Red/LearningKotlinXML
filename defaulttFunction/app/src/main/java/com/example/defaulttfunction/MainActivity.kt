package com.example.defaulttfunction

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
import com.example.defaulttfunction.ui.theme.DefaulttFunctionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        orderProduct(product = "Iphone 16 plus", PostalService = "RAM")
        val soldier1 = Soldier()
        Log.i("Name", soldier1.name)
        Log.i("Rank", soldier1.rank)
        Log.i("MIA", "${soldier1.missing}")
        soldier1.bullets
        soldier1.bullets = 75
        Log.i("Total weight", "${soldier1.totalWeight}")
        soldier1.getStatus()

        val animalFarm = Book("Animal Farm", 2000000)

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


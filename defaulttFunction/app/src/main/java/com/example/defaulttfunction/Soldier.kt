package com.example.defaulttfunction

import android.util.Log

class Soldier {
    val name = "Ryan"
    val rank = "Private"
    var missing = true

    var bullets = 100
        get(){
            Log.i("Getter being used", "Value = $field")
            return field
        }
        set(value){
            field = if(value < 0) 0 else value
            Log.i("Setter being used", "New value = $field")
        }

    var packWeight = 150
    val gunWeight = 100
    var totalWeight = packWeight + gunWeight
        get() = packWeight + gunWeight

    fun getStatus(){
        var status = "$name $rank"
        if(missing){
            status = "$status is missing"
        }else{
            status = "$status is not missing"
        }

        Log.i("Status", status)
    }
}
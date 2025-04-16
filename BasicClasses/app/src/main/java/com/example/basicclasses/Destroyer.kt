package com.example.basicclasses

import android.util.Log

class Destroyer(name: String) {
    // What is the name of this ship
    var name: String = ""
        private set

    // What type of ship is it
    // Always a destroyer
    val type = "Destroyer"

    // How much the ship can take before sinking
    private var hullIntegrity = 100

    var ammo = 1
        private set

    private var shotPower = 60

    private var sunk = false

    init{
        this.name = name
    }

    fun takeDamage(damageTaken:Int){
        if(!sunk){
           hullIntegrity -= damageTaken
           Log.i("$name damage taken =", "$damageTaken")
           Log.i("$name hull integrity =", "$hullIntegrity")

           if(hullIntegrity <= 0){
               Log.d("Destroyer", "$name has been Sunk!!")
               sunk = true
           }
        }else{
            Log.d("Error", "Ship does not exist")
        }
    }

    fun shootShell():Int{
        return if (ammo > 0) {
            ammo --
            shotPower
        }else{
            0
        }
    }

    fun serviceShip(){
        ammo = 10
        hullIntegrity = 100
    }
}
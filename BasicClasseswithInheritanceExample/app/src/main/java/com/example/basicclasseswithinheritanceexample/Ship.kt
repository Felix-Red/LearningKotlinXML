package com.example.basicclasseswithinheritanceexample

import android.util.Log

abstract class Ship(val name: String, private var type: String, private val maxAttacks:Int, private val maxhullIntegrity: Int) {
        private var sunk = false
        private var hullIntegrity: Int
        protected var attacksRemaining: Int

        init {
            hullIntegrity = this.maxhullIntegrity
            attacksRemaining = 1
        }

    fun takeDamage(damageTaken: Int){
        if(!sunk){
            hullIntegrity -= damageTaken
            Log.i("$name damage taken =", "$damageTaken")
            Log.i("$name hull integrity =", "$hullIntegrity")

            if (hullIntegrity <= 0){
                Log.i(type, "$name has been sunk")
                sunk = true
            }else{
                Log.i("Error", "Ship does not exist")
            }
        }
    }
    fun serviceShip(){
        attacksRemaining = maxAttacks
        hullIntegrity = maxhullIntegrity
    }

    fun showStats(){
        Log.i("$type $name", "Attacks: $attacksRemaining - Hull: $hullIntegrity")

    }

    abstract fun attack(): Int


}
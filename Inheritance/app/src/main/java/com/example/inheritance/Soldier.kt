package com.example.inheritance

import android.util.Log

open class Soldier {
    open fun shoot(){
        Log.d("Action", "Bang bang bang")
    }
}

class specialForces: Soldier() {
    fun sneakUpOnEnemy(){
        Log.i("Action", "Sneaking up on enemy")
    }
}

class paratrooper: Soldier(){
    fun jumpOutOfPlane(){
        Log.i("Action", "Jump out of plane")
    }
}

class sniper: Soldier(){

    var snipperRiffleAmmo = 3

    override fun shoot(){
        if(snipperRiffleAmmo > 0){
            Log.i("Action", "steady...Adjust for wind...Bang")
            snipperRiffleAmmo--
        }else{
            super.shoot()
        }

    }

    fun getIntoPosition(){
        Log.i("Action", "Preparing line of sight to target")
    }
}


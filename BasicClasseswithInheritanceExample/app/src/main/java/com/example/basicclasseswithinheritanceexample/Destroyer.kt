package com.example.basicclasseswithinheritanceexample

class Destroyer(name: String): Ship(name, "Destroyer", 10, 200) {

    private var shotPower = 60

    override fun attack(): Int {
        return if (attacksRemaining > 0){
            attacksRemaining--
            shotPower
        }else{
            0
        }
    }
}
package com.example.basicclasseswithinheritanceexample

class Carrier(name: String): Ship(name, "Carrier", 20, 100) {
    private var attackPower = 120
    override fun attack(): Int {
        return if (attacksRemaining>0){
            attacksRemaining--
            attackPower
        }else{
            0
        }
    }
}
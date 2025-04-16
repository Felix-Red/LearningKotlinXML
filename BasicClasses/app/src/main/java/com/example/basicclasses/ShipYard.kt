package com.example.basicclasses

class ShipYard {
    fun serviceDestroyer(destroyer: Destroyer){
        destroyer.serviceShip()
    }

    fun serviceCarrier(carrier: Carrier){
        carrier.serviceShip()
    }
}
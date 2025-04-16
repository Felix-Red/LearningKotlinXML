package com.example.basicclasseswithinheritanceexample

import android.os.Bundle
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
import com.example.basicclasseswithinheritanceexample.ui.theme.BasicClassesWithInheritanceExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val friendlyDestroyer = Destroyer("Invincible")
        val friendlyCarrier = Carrier("Indomitable")

        val enemyDestroyer = Destroyer("Grey Death")
        val enemyCarrier = Carrier("Big grey Death")

        val friendlyShipyard = ShipYard()

        friendlyDestroyer.takeDamage(enemyDestroyer.attack())
        friendlyDestroyer.takeDamage(enemyCarrier.attack())

        enemyCarrier.takeDamage(friendlyCarrier.attack())
        enemyCarrier.takeDamage(friendlyDestroyer.attack())

        friendlyDestroyer.showStats()
        friendlyCarrier.showStats()

        friendlyShipyard.serviceShip(friendlyCarrier)
        friendlyShipyard.serviceShip(friendlyDestroyer)

        friendlyDestroyer.showStats()
        friendlyCarrier.showStats()

        enemyDestroyer.takeDamage(friendlyDestroyer.attack())
        enemyDestroyer.takeDamage(friendlyCarrier.attack())
        enemyDestroyer.takeDamage(friendlyDestroyer.attack())



    }
}


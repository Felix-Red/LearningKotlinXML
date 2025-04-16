package com.example.inheritance

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
import com.example.inheritance.ui.theme.InheritanceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val ryan = Soldier()
        ryan.shoot()

        val heis = specialForces()
        heis.sneakUpOnEnemy()
        heis.shoot()

        val mickey = paratrooper()
        mickey.jumpOutOfPlane()
        mickey.shoot()

        val ghost = sniper()
        ghost.getIntoPosition()
        ghost.shoot()
        ghost.shoot()
        ghost.shoot()
        ghost.shoot()
    }
}


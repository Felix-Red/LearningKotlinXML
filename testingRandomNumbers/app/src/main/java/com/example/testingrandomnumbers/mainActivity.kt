package com.example.testingrandomnumbers

import kotlin.random.Random

fun main() {
    val randGenerator = Random.nextInt(10)

    //number arrays
    var myIntArray = IntArray(10)
    var stringArray = Array(5) {""}

    //string arrays
    stringArray[0] = "Hello"
    stringArray[1] = "From"
    stringArray[2] = "Kotlin"
    stringArray[3] = "!"
    stringArray[4] = ":)"

    var evenMoreStringArray = arrayOf("Hello", "From", "Kotlin", "!")

    for (i in evenMoreStringArray) {
        println(i)
    }

    myIntArray[0] = randGenerator
    println(myIntArray[0])

    //2 dimentional arrays in kotlin

    val cities = arrayOf("London", "New York", "Yarren")
    val countries = arrayOf("UK", "USA", "Ireland")
    val citiesAndCountries = arrayOf(cities, countries)

    println("The capital of ${citiesAndCountries[0][0]} is ${citiesAndCountries[1][0]}")
}
package com.example.simplearrayexample

fun main(){
    val answer = arrayOf(25, 50, 125, 68, 47)

    for (i in answer){
        println(i)
    }
    var total = 0
    for(i in answer){
        total += i
    }
    println(total)


    //Array list:
    var myList = ArrayList<String>()

    myList.add("Felix Red")
    myList.add("Felix 17")
    myList.add(1, "Felix Mandyme")

    for(i in myList){
        println(i)
    }


    //hashmap

    val myCharacterMap = HashMap<String, Int>()
    myCharacterMap.put("Felix", 17)
    myCharacterMap.put("Felix", 18)



}

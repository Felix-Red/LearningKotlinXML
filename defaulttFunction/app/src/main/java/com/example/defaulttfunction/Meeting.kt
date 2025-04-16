package com.example.defaulttfunction
// Perhaps the user of the class
// doesn't know the time as it
// is yet to be confirmed
class Meeting(val day:String, val person:String) {
   var time:String = "To be decided"
    constructor(day: String, person: String, time:String):this(day, person){
        // The user of the class can
        // supply the day, time and person
        // of a meeting

        this.time = time
    }


}
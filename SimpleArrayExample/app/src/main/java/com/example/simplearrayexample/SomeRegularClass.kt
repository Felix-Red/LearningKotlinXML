package com.example.simplearrayexample

class SomeRegularClass {
    var someRegularProperty = 1

    val innerClassObject = SomeInnerClass()


    fun someRegularFunction(){
        //something later
        innerClassObject.innerClassFunction()

    }

    inner class SomeInnerClass{
        var innerClassProperty = 8

        fun innerClassFunction(){
            someRegularProperty++
        }
    }
}
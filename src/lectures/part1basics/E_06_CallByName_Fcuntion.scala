package lectures.part1basics

import Utils.out

object E_06_CallByName_Fcuntion extends App{

    out("Call by Name vs Call by Value Functions!")

    def calledByValue(x: Long): Unit = {
        println("by value: " + x) // this is translated to: println("by name: " + 100428588106821)
        println("by value: " + x) // this is translated to: println("by name: " + 100428588106821)
    }

    def calledByName(x: => Long): Unit = {
        // The 'x' variable holds an expression that it is evaluated every time the variable is used
        println("by name: " + x) // this is translated to: println("by name: " + System.nanoTime())
        println("by name: " + x) // this is translated to: println("by name: " + System.nanoTime())
    }

    calledByValue(System.nanoTime()) // The System.nanoTime() return a value and is sent to the calledByValue function
    // and the value is used whenever it is used, and it is the same value all the time

    calledByName(System.nanoTime()) // The System.nanoTime() Expression is passed to the function
    // and it the expression is executed as many times it is used

    //NOTE: The arrow operator (=>) it is lazy, if the expression is never used inside the body of the function
    // then it is never executed. Example:

    def infinite(): Int = 1 + infinite()

    def printFirst(x: Int, y: => Int)  = println(x)

    //printFirst(infinite(), 34) // it crashes: Stackoverflow error
    printFirst(34, infinite())

}

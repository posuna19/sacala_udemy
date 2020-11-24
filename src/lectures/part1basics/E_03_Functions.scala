package lectures.part1basics

import Utils.out

import scala.annotation.tailrec

object E_03_Functions extends App {

  out("Functions")


  def aFunction(a: String, b: String): String = {
    s"$a $b"
  }

  out(aFunction("Hello", "Function"))

  def aNoParameterFunction(): Int = 42

  out(s"Parameterless function call: ${aNoParameterFunction()}")


  def aRepeatedFunction(aString: String, n: Int): String = {
    if(n == 1)
        aString
    else
        aString + aRepeatedFunction(aString, n - 1)
  }

  out(aRepeatedFunction("Sun", 3))
  out("WHEN you need loops use recursion")
  out("Best practice: always specify the return type of a function")

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)
  out("Use unit when you want to display something, or write to a file. Units represent the void")


  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n-1)
  }


  out("You can define functions inside a function: " +
  aBigFunction(6))

  def greetings(name: String, age: Int): String = {
    s"Hi, my name is $name and I am $age years old"
  }

  def factorial(num: Int): Int = {
    if(num <= 1 )
      1
    else
      num * factorial(num - 1)
  }

  def fibonacci(num: Int): Int = {
    if(num <= 2)
      1
    else
      fibonacci(num-1) + fibonacci(num-2)
  }

  def isPrime(num: Int): Boolean = {

    @tailrec
    def isPrimeUntil(t: Int): Boolean =
      if(t <= 1)
        true
      else
        num % t != 0 && isPrimeUntil(t-1)

    isPrimeUntil(num/2)
  }

  out("Exercices:")
  out("1. Greeting function " + greetings("Pedro", 34))
  out(s"2. The factorial of 10 is: ${factorial(10)}")
  out(s"3. The fibonacci of 10 is: ${fibonacci(10)}")
  out(s"4. The isPrime of 15 is: ${isPrime(17)}")
}

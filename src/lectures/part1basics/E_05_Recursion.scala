package lectures.part1basics

import Utils.out

import scala.annotation.tailrec

object E_05_Recursion extends App {



  def factorial(num: Int): Int = {
    if(num <= 1 )
      1
    else
      num * factorial(num - 1)
  }


  def anotherFactorial(n: BigInt): BigInt = {

    @tailrec
    def factorialHelper(x: BigInt, accumulator: BigInt): BigInt = {
      if(x <= 1)
        accumulator
      else
        factorialHelper(x - 1, x * accumulator) // TAIL RECURSION: IN THE EXPRESSION
    }

    factorialHelper(n, 1)
  }

  out(anotherFactorial(20) toString)

  // When you need loops, user _TAIL_ RECURSION
  // Use acumulators as many as you need

  def repeatStr(s: String, t: Int): String = {

    @tailrec
    def repeatHelper(aux: String, t1: Int, accumulator: String): String = {
      if(t1 <= 0)
        accumulator
      else
        repeatHelper(s, t1 - 1, s + accumulator)

    }

    repeatHelper(s, t, s"")
  }

  def fibonacci(num: Int): Int = {

    @tailrec
    def helper(i: Int, last: Int, nextToLast: Int): Int = {
      if(i >= num)
        last
      else
        helper(i + 1, last + nextToLast, last)
    }

    if(num <= 2)
      1
    else
      helper(2, 1, 1)

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

  // Exercises:

  out("Tail Recursion exercises:")
  out(s"1. Concatenating a string n times: ${repeatStr("hello", 3)}")
  out(s"2. Is Prime: ${isPrime(17)}")
  out(s"3. Fibonacci: ${fibonacci(10)}")

}

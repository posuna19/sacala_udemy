package lectures.part2oop

object E_18_Exception extends App {

  val x: String = null


  // 1. Throwing exceptions

  //val aWeirdValue: String = throw new NullPointerException


  // Throwable classes extends the Trhowable class
  // Exception and Error are the major Throwable subtypes


  // 2. Catching exceptions

  def getInt(withExeptions: Boolean): Int =
    if(withExeptions)
      throw new RuntimeException("No int for you!")
    else
      42

  val fail = try {
    getInt(true)

  } catch {
    case e: RuntimeException => println("Caught a Runtime exception")

  } finally {

    println("Finally")
  }

  // 3. How to define your own exceptions
  class MyException extends Exception

  val exception = new MyException

  //throw exception

//  try {
//
//    val sb: StringBuilder = new StringBuilder
//    while (true)
//      sb.append("aaaaaaaaaaaaaaaaaa")
//
//  } catch {
//    case ex: OutOfMemoryError => println("Max KI reached!")
//
//  }

  def recursiveMethod(n: Long): Int = {
    if(n <= 0)
      return -1
    else
      recursiveMethod(n - 1) + recursiveMethod(n - 1)
  }

  try {
    recursiveMethod(50000000000L)

  } catch {
    case ex: StackOverflowError => println("To many calls")

  }





}

class OverflowException extends Exception
class UnderflowException extends Exception
class MathCalculationException extends Exception

class PocketCalculator {

  def add(x: Int, y: Int): Int = {
    val result = x + y
    if(x > 0 && y > 0 && result < 0)
      throw new OverflowException
    else if(x < 0 && y < 0 && result > 0)
      throw new UnderflowException
    else
      result
  }

  def substract(x: Int, y:Int): Int = {
    val result = x - y
    if(x > 0 && y < 0 && result < 0)
      throw new OverflowException
    else if(x < 0 && y > 0 && result > 0)
      throw new UnderflowException
    else
      result
  }

  def multiply(x: Int, y:Int): Int = {
    val result = x * y
    if(x > 0 && y > 0 && result < 0)
      throw new OverflowException
    else if(x < 0 && y < 0 && result < 0)
      throw new OverflowException
    else if(x > 0 && y < 0 && result > 0)
      throw new UnderflowException
    else if(x < 0 && y < 0 && result > 0)
      throw new UnderflowException
    else
      result
  }

  def divide(x: Int, y: Int): Int = {
    if(y == 0)
      throw new MathCalculationException
    else
      x / y
  }


}

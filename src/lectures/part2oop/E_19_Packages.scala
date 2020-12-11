package lectures.part2oop


import java.util.Date
import java.sql.{Date => SqlDate}


object E_19_Packages extends App {


  // package objects
  // Are rarely used
  sayHello
  println(s"The speed of light is $SPEED_OF_LIGHT")


  // IMPORT when same class names
  // 1. Use qualified names
  val d1 = new java.util.Date()


  // 2. Use alias
  val d2 = new SqlDate(1L)



  // DEFAULT Imports, every class in scalla all these imports are avaiable:
  // - java.lang: String, Object, Exception
  // - scala: Int, Nothing, Function
  // - scala.predef: println, ???

}

package lectures.part1basics

import Utils.out

object E_08_Strings_Ops extends App {

  out("Smart operation in Strings")

  val str = "Hello, I am learning Scala"

  out(str.charAt(2).toString)
  out(str.substring(7,11))
  out(str.split(" ").toList.toString)
  out(str.startsWith("Hello").toString)
  out(str.replace(" ", "-"))
  out(str.toLowerCase())
  out(str.length.toString)

  val aStr = "45"
  val aNum: Int = aStr.toInt // Convert a string to a number
  out(s"The number is $aNum")

  out()
  out("Scala specific mehtods and operators")
  //Preappending and appending
  // The preappending operator is +:
  // The appending operator is :+
  out(s"${'a' +: aStr :+ 'z'}")
  out(str.reverse)
  out(str.take(4))

  out()
  out("String interpolators")

  val name = "David"
  val age = "12"
  val greeting = s"Hello, my  name is $name and I am $age years old"
  val anotherGreeting = s"Hello, I will be turning ${age.toInt + 1}"
  out(s"$anotherGreeting")

  // F-Interpolators
  val speed = 1.2f
  val myth = f"$name can eat $speed%2.3f burgers per minute"
  out(myth)


  // Raw Interpolators

  out(raw"This is a \n new line") // The \n char is printed literally

  val escaped = "This is a \n new line" // The \n will be scaped
  out(raw"$escaped") // Raw strings with string interpolator do not work
}

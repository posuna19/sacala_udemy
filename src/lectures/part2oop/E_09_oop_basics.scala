package lectures.part2oop

import lectures.part1basics.Utils.out

object E_09_oop_basics extends App {

  val person = new Person("Jhon", 26)
  out(person.age)
  out(person.x)
  person.greet("Daniel")
  person.greet()

  val p2 = new Person("Pedro")
}


class Person(name: String, val age: Int) { //class parameters are not class member

  // body: is executed on every object that is created

  // variables
  val x = 2

  // Expressions
  out( 1 + 3)

  // method
  def greet(name: String): Unit = {
    out(s"${this.name} says: Hi, $name")
  }

  // overloading
  def greet(): Unit = out(s"Hi I am $name")

  // multiple contructors: auxilary constructors
  // Are used only to call other constructors with default parameters
  // C
  def this(name: String) = {
    this(name, 0)
    out("Constructor with name only")

  }

  def this() = {
    this("John Doe")
  }

}
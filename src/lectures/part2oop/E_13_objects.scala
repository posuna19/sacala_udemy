package lectures.part2oop

import lectures.part1basics.Utils.out

object E_13_objects extends App {

  out("Objects")

  object Person {
    val N_EYES = 2
    def canFly: Boolean = false

    def from(mother: Person, father: Person): Person = new Person("Bobbie")
    def apply(mother: Person, father: Person): Person = new Person("Karl")
  }

  class Person(val name: String = "") {


  }

  out(s"The constant value is ${Person.N_EYES}")
  out(s"A method call ${Person.canFly}")

  val mary = new Person()
  val john = new Person()
  out(s"The comparission in instances is ${mary == john}")

  val per1 = Person
  val per2 = Person
  out(s"The comparission in objects is ${per1 == per2}")

  out("Factory methods")
  val p1 = Person.from(mary, john) // calling the from method
  val p2 = Person.apply(mary, john) // calling the apply method
  val p3 = Person(mary, john) // calling the apply method implicitly


}

package lectures.part2oop

import lectures.part1basics.Utils.out

object E_16_AnonymousClasses extends App{

  abstract class Animal {
    def eat: Unit
  }

  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = out("hahahaha") // Provide the implementation of any abstracts class
  }

  funnyAnimal.eat
  out(funnyAnimal.getClass)

  class Person(name: String) {
    def sayHi: Unit = out(s"Hi my name is $name")
  }

  val jim = new Person("Jim") { // Pass the parameters even for the anonymous classes
    override def sayHi: Unit = out(s"Hi my name is Jim")
  }


}

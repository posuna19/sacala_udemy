package lectures.part2oop

import  lectures.part1basics.Utils.out

object E_14_Inheritance_traits extends App {

  out("Inheritance and Traits")

  sealed class Animal {
    val creatureType = "Wild"
    def eat = out("nomnom")
  }

  class Cat extends Animal {

    def crunch = {
      eat
      out("crunch crunch")
    }

  }

  val cat = new Cat
  //cat.eat
  cat.crunch

  class Person(name: String, age: Int) {
    // constructor
    def this(name: String) = this(name, 0)
  }

  // extension
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)


  class Dog extends Animal {
    override val creatureType: String = "Domestic"
    // overriding a method
    override def eat = {
      super.eat
      out("crunch crunch dog") }
  }

  val dog = new Dog()
  dog.eat
  out(dog.creatureType)

  //Overriding in the constructor
  class Dog2(override val creatureType: String) extends Animal {
    override def eat = out("crunch crunch dog2")
  }

  val dog2 = new Dog2("K9")
  dog2.eat
  out(dog2.creatureType)


  // type substitution: (broad: polymorphism)
  val unkownAnimal: Animal = new Dog2("Wild dog")
  unkownAnimal.eat


  // super: call a method from the parent class

  // preventing overrides
  // 1. Use the key word final on the method
  // 2. Use the final on the class
  // 3. seal the class = extend classes in THIS FILE, prevent extension on other class.
  // USE the sealed key word
  //
}

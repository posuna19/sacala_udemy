package lectures.part2oop

import lectures.part1basics.Utils.out

object E_14_Inheritance_traits2 extends App {

  abstract class Animal {
    val creatureType: String = "Wild"
    def eat: Unit

  }


  class Dog extends Animal {
    override val creatureType: String = "Canine"
    override def eat: Unit = out("crunch crunch")
  }


  // traits: They can be inheritance along with classes
  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredMeal: String = "fresh meal"
  }

  trait ColdBlooded
  class Crocodile extends Animal with Carnivore {
    override val creatureType: String = "croc"
    def eat: Unit = "nomnomnom"
    def eat(animal: Animal): Unit = out(s"I'm a croc and I am eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)


  // traits vs abstracts classes
  // 1. traits do not have constructor parameters
  // 2. You can extends only 1 class, with traits, you can use multiple traits in a class
  // 3. Traits are behaviour, abstract class describe a type




}

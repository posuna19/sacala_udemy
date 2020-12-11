package lectures.part2oop

import lectures.part1basics.Utils.out

object E_15_Generics extends App{

  class MyList[A] { // Generic class
    // use the type A
  }


  class MyList2[+A] {

    def add[B >: A](element: B): MyList2[B] = ???

    /*
    A = Cat
    B = Animal

     */
  }


  trait MyTrait[A] { // Generic class
    // use the type A
  }

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  val genericTrait = new MyTrait[Integer] {}





  // objects cannot be parameterized


  // Generic methods

  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfInteger = MyList.empty[Int]


  // variance problem

  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // 1. YES. List[Cat] extends List[Animal] = Covariance
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) ?? --> Answer = we return a list of animals


  //2. NO = Invariance
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]


  //3. NO = Contravariance
  class ContravariantList[-A]
  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]

  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]



  // bounded types
  class Cage[A <: Animal](animal: A) // upper bounded type
  val cage = new Cage(new Dog)


//  class Car
//  val newCage = new Cage(new Car) // this gives error


  class Cage2[A >: Animal](animal: A) // lower bounded type
  val cage2 = new Cage(new Cat)



}

package lectures.part2oop

object E_17_case_classes extends App {
  println("Case classes")

  /*

    equals, hashCode, toString

   */

  case class Person(name: String, age: Int)

  // 1. class parameters are promoted fields
  val jim = new Person("Jim", 34)
  println(jim.name)

  // 2. It provides toString method implementation
  println(jim.toString)
  println(jim) // toString method is called automatically

  // 3. Equals and hashCode implemented out of the box
  val jim2 = new Person("Jim", 34)
  println(jim == jim2)

  // 4. case classes have handy copy methods
  val jim3 = jim.copy(age = 45)
  println(jim3)

  // 5. Case classes have companion objects automatically
  val thePerson = Person // New instance from the object class

  val mary = Person("Mary", 23) // no new keyword needed to instatiate

  // 6. Case classes are serializable, e.g. messages in AKKA

  // 7. Case classes have extractor patterns = case classes can be used in PATTERN MATCHING

  case object UnitedKindom {
    def name: String = "The UK of GB and NI"
  }


}

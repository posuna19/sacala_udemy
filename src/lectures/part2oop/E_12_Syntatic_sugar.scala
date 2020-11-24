package lectures.part2oop

import lectures.part1basics.Utils.out

object E_12_Syntatic_sugar extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def hangOutWith(person: Person): String =
      s"${this.name} is hanging out with ${person.name}"

    def +(person: Person) = this.hangOutWith(person)
    def +(str: String): Person = new Person(this.name + " (" + str + ")", this.favoriteMovie)

    def unary_! : String = s"$name What the heck?!"
    def unary_+ : Person = new Person(this.name, this.favoriteMovie, this.age + 1) // keep a space between the unary_+ and the colon(:)
    def isAlive: Boolean = true

    def apply(): String = s"Hi my name is $name, and I like $favoriteMovie"
    def apply(n: Int): String = s"$name watched $favoriteMovie $n times"

    def learns(learn: String): String = s"$name learns $learn"
    def learnsScala: String = learns("Scala")
  }

  val mary = new Person("Mary", "Inception")
  out(mary.likes("Inception"))

  // Infix notation = operator notation (Syntatic sugar)
  // works only with one parameter:
  out(mary likes "Inception")

  val tom = new Person("Tom", "Fight Club")
  out(mary hangOutWith tom)
  out(mary + tom)


  // All operators are methods. Example:
  out(1 + 2)
  out(1.+(2))


  // Prefix Notation = Unary operators
  val x = -1 // equivalent with 1.unary_- method
  val y = 1.unary_-
  out(s"x: $x and y:$y")
  // Uniday_ prefix only works with + - ~ (tilda) !(bang)
  out(s"o_O ${!tom}") // or
  out(s"o_O ${tom.unary_!}")


  // Postfix Notation
  out(mary.isAlive) // Best practice
  out(mary isAlive) // postfix notation is vaiable without parameters


  // Apply method
  out(mary.apply()) // is equivalent to mary()
  out(mary()) // is calling the apply method


  // Exercise 1
  out((mary + "The rockstar")()) // it is calling the apply method on the resulting object
  out((mary + "The rockstar").apply()) // it is calling the apply method on the resulting object

  // Exercise 2
  out("Age is: " + (+mary).age)

  // Exercise 3
  out(mary.learns("Math"))
  out(mary learnsScala) // Post fix notation


  // Exercise 4
  out(mary.apply(5))
}

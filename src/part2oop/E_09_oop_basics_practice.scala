package part2oop

import lectures.part1basics.Utils.out

object E_09_oop_practice extends App {

  val writer: Writer = new Writer("Pablo", "Jimenez", 1970)
  out(s"The author's name is: ${writer.fullName}")

  val novel: Novel = new Novel("The backyard", 2020, writer)
  out(s"The age of the author is: ${novel.authorAge}")

  val otherAuthor: Writer = new Writer("Romelio", "Escandiba", 1981)

  out(s"The novel's author comparisson is: ${novel.isWritenBy(otherAuthor)}")

  val copy: Novel = novel.copy(2021)
  out(s"The new release year of copy is: ${copy.releaseYear}")

  val counter: Counter = new Counter(5)
  out(s"The counter is: ${counter.increment.increment.increment.currentCount}")
  out(s"The counter plus 10 is: ${counter.increment(10).currentCount}")
  out(s"The counter minus 15 is: ${counter.decrement(15).currentCount}")
}

class Writer(val firstName: String, val surName: String, val year: Int) {


  def fullName = s"$firstName $surName"
}

class Novel(val name: String, val releaseYear: Int, var author: Writer) {

  def authorAge: Int  =  releaseYear - author.year//at the year of the release

  def isWritenBy(author: Writer): Boolean = this.author == author

  def copy(releaseYear: Int): Novel = new Novel(name, releaseYear, author)

}

class Counter(val n: Int) {

  def increment() = new Counter(n + 1)

  def increment(amt: Int): Counter = { // new Counter(n + amt)
    if(amt <= 0)
      this
    else
      increment().increment(amt - 1)
  }

  def decrement() = new Counter(n - 1)

  def decrement(amt: Int): Counter = { // new Counter(n + amt)
    if(amt <= 0)
      this
    else
      decrement().decrement(amt - 1)
  }

  def currentCount = n

}



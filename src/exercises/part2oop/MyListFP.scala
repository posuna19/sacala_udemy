package exercises.part2oop

// This Class is done with the Functional programing instead of using regular traits
abstract class MyListFP[+A] {

  def head: A
  def tail: MyListFP[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyListFP[B]
  def printElements: String
  override def toString: String = "[" + printElements + "]"

  def map[B](transformer: A => B): MyListFP[B]
  def flatMap[B](transformer: A => MyListFP[B]): MyListFP[B]
  def filter(predicate: A => Boolean): MyListFP[A]

  // concatenation
  def ++[B >: A](list: MyListFP[B]): MyListFP[B]
}


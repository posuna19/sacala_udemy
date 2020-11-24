package part2oop

import lectures.part1basics.Utils.out

import scala.annotation.tailrec

object E_14_Inheritance_traits_ecercises extends App{

  /*val clist: CustomList = new CustomList
  out(s"The list is Empty: ${clist.isEmpty}")
  clist.add(4)
  clist.add(5)
  clist.add(9)
  clist.add(7)
  out("The list is: " + clist.toString)

  out(s"The head is: ${clist.head}")
  out(s"The tail is: ${clist.tail.value}")
  out(s"The list is Empty: ${clist.isEmpty}")*/


  // test CustomList2
  val emp: MyList = EmptyList // Objects cannot be instatiated
  out(emp)

  val cl2: MyList = emp.add(3)
  out(cl2)

  val cl3 = cl2.add(6).add(7)
  out(cl3)

  val l = new CustomList2(1, new CustomList2(2, new CustomList2(3, EmptyList)))
  out(l)

  val l2 = new CustomList2(4, l)
  out(l2)


}

class Node (var value: Any) {

  var right: Node = null


}

abstract class MyList {


  /*

  head = first element of the list
  tail = reminder of the list
  isEmpty = is this list empty
  add(int) => new list with this element added
  toString => a string representation of the list


   */

  def head: Int
  def tail: MyList
  def isEmpty: Boolean
  def add(n: Int): MyList
  def printElements: String
  override def toString: String = "[" + printElements + "]"

}


class CustomList1 extends MyList {



  /*

  head = first element of the list
  tail = reminder of the list
  isEmpty = is this list empty
  add(int) => new list with this element added
  toString => a string representation of the list

  ----------------

  var headNode: Node = null
  var last: Node = null



  def head: Int = {
    if(headNode != null)
      headNode.value.toString.toInt
    else
      0
  }

  def tail: MyList = {
      null
  }

  def isEmpty: Boolean =
    if(headNode == null)
      true
    else
      false

  def add(n: Int) = {
    if(headNode == null) {
      headNode = new Node(n)
      last = headNode
    } else {
      var node = headNode
      var continue: Boolean = true
      while(node != null && continue) {
        if(node.right != null)
          node = node.right
        else
          continue = false
      }

      val newNode: Node = new Node(n)
      node.right = newNode
      last = node.right
    }
  }

  override def toString: String = {

    var nums = ""
    var head = headNode
    while(head != null) {
      nums += head.value + ", "
      head = head.right
    }
    "MyList[" + nums + "]"
  }


   */
  override def head: Int = ???

  override def tail: MyList = ???

  override def isEmpty: Boolean = ???

  override def add(n: Int): MyList = ???

  override def printElements: String = ???
}


object EmptyList extends MyList {
  override def head: Int = throw new NoSuchElementException

  override def tail: MyList = ??? // or thow new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add(n: Int): MyList = new CustomList2(n, EmptyList)

  override def printElements: String = ""

}


class CustomList2(h: Int, t: MyList) extends MyList {

  override def head: Int = h

  override def tail: MyList = t

  override def isEmpty: Boolean = false

  override def add(n: Int): MyList = new CustomList2(n, this)

  //@tailrec
  override def printElements: String = {
    if(t.isEmpty)
      "" + h
    else
      h + " " + t.printElements
  }

}




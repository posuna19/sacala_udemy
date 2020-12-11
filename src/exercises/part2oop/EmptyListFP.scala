package exercises.part2oop

// Functional Programming style

case object EmptyListFP extends MyListFP[Nothing] {

  override def head: Nothing = throw new NoSuchElementException

  override def tail: MyListFP[Nothing] = ??? // or thow new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](element: B): MyListFP[B] = new CustomListFP(element, EmptyListFP)

  override def printElements: String = ""

  def map[B](transformer: Nothing => B): MyListFP[B] = EmptyListFP
  def flatMap[B](transformer: Nothing => MyList[B]): MyListFP[B] = EmptyListFP
  def filter(predicate: Nothing => Boolean): MyListFP[Nothing] = EmptyListFP

  def ++[B >: Nothing](list: MyListFP[B]): MyListFP[B] = list

}

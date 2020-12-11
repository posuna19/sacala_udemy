package exercises.part2oop


case object EmptyList extends MyList[Nothing] {

  override def head: Nothing = throw new NoSuchElementException

  override def tail: MyList[Nothing] = ??? // or thow new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add[B >: Nothing](element: B): MyList[B] = new CustomList(element, EmptyList)

  override def printElements: String = ""

  def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = EmptyList
  def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = EmptyList
  def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = EmptyList

  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

}

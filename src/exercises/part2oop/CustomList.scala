package exercises.part2oop


case class CustomList[+A](h: A, t: MyList[A]) extends MyList[A] {

  override def head: A = h

  override def tail: MyList[A] = t

  override def isEmpty: Boolean = false

  override def add[B >: A](element: B): MyList[B] = new CustomList(element, this)

  //@tailrec
  override def printElements: String = {
    if (t.isEmpty)
      "" + h
    else
      h + " " + t.printElements
  }

  /*
  [1,2,3].map(n * 2)
	  = new CustomList(2, [2,3].map(n * 2))
	    = new CustomList(2, new CustomList(4, [3].map(n * 2)))
	    = new CustomList(2, new CustomList(4, new CustomList(6, Empty.map(n * 2))))
	    = new CustomList(2, new CustomList(4, new CustomList(6, Empty))))
   */
  def map[B](transformer: MyTransformer[A, B]): MyList[B] = {
    new CustomList(transformer.transform(h), t.map(transformer))

  }


  /*
  [1,2].flatMap(n => [n + 1])
    = [1,2] ++ [2].flatMap(n => [n, n + 1])
    = [1,2] ++ [2,3] ++ EmptyList.flatMap(n => [n, n + 1])
    = [1,2] ++ [2,3] ++ Empty
    = [1,2,2,3]
   */
  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B] =
    transformer.transform(h) ++ t.flatMap(transformer)

  /*
  [1,2,3].filter(n % 2 == 0) =
	  [2,3].filter(n % 2 == 0) =
	    = new CustomList(2, [3].filter(n % 2 == 0))
	    = new CustomList(2, Empty.filter(n % 2 == 0 ))
	    = new CustomList(2, Empty)
  */
  def filter(predicate: MyPredicate[A]): MyList[A] = {
    if(predicate.test(h)) {
      new CustomList(h, t.filter(predicate))

    } else {
      t.filter(predicate)
    }
  }

  /*
  [1,2] ++ [3,4,5]
    = new CustomList(1, [2] ++ [3,4,5])
    = new CustomList(1, new CustomList(2, Empty ++ [3,4,5]))
    = new CustomList(1, new CustomList(2, new CustomList(3, new CustomList(4, new CustomList(5)))))
   */

  def ++[B >: A](list: MyList[B]): MyList[B] = {
    new CustomList(h, t ++ list)
  }


}

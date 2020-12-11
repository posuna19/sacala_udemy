package exercises.part2oop

// This class is done with Functiona programming

case class CustomListFP[+A](h: A, t: MyListFP[A]) extends MyListFP[A] {

  override def head: A = h

  override def tail: MyListFP[A] = t

  override def isEmpty: Boolean = false

  override def add[B >: A](element: B): MyListFP[B] = new CustomListFP(element, this)

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
  def map[B](transformer: A => B): MyListFP[B] = {
    new CustomListFP(transformer(h) /* or transformer.apply(h)*/, t.map(transformer))
  }


  /*
  [1,2].flatMap(n => [n + 1])
    = [1,2] ++ [2].flatMap(n => [n, n + 1])
    = [1,2] ++ [2,3] ++ EmptyList.flatMap(n => [n, n + 1])
    = [1,2] ++ [2,3] ++ Empty
    = [1,2,2,3]
   */
  def flatMap[B](transformer: A => MyListFP[B]): MyListFP[B] =
    transformer(h) ++ t.flatMap(transformer)

  /*
  [1,2,3].filter(n % 2 == 0) =
	  [2,3].filter(n % 2 == 0) =
	    = new CustomList(2, [3].filter(n % 2 == 0))
	    = new CustomList(2, Empty.filter(n % 2 == 0 ))
	    = new CustomList(2, Empty)
  */
  def filter(predicate: A => Boolean): MyListFP[A] = {
    if(predicate(h) /*|| predicate.apply(h)*/) {
      new CustomListFP(h, t.filter(predicate))

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

  def ++[B >: A](list: MyListFP[B]): MyListFP[B] = {
    new CustomListFP(h, t ++ list)
  }


}

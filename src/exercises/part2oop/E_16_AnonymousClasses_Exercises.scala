package exercises.part2oop

object E_16_AnonymousClasses_Exercises extends App{

  println("Anonymous exercises")

  val intList: MyList[Int] = new CustomList(1, new CustomList(2, new CustomList(3, EmptyList)))
  println(intList)

  // Map test
  val mapList = intList.map(new MyTransformer[Int, Int] {
    override def transform(element: Int): Int = element * 2
  })

  println("List with map: " + mapList)


  // Filter test
  println("List with filter: " + intList.filter( new MyPredicate[Int] {
    override def test(elem: Int): Boolean = elem % 2 == 0
  } ))


  val list2: MyList[Int] = new CustomList(4, new CustomList(5, EmptyList))

  // concatenation
  println("intList ++ list2: " + (intList ++ list2))

  // flat Map -> Converts a number into a list of the number it self plus another number + 1, i.g. n => n + 1
  println(intList.flatMap(new MyTransformer[Int, MyList[Int]] {
    override def transform(elem: Int): MyList[Int] =
      new CustomList(elem, new CustomList(elem + 1, EmptyList))
  }))

}

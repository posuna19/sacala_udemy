package exercises.part2oop

object E_17_case_classes_exercises extends App {
  println("Case classes")

  val intList: CustomList[Int] = new CustomList(1, new CustomList(2, new CustomList(3, EmptyList)))
  println(intList)

  val copyList = intList.copy()

  println(s"The copy list is: $copyList")
  println(s"list comparisson: ${copyList == intList}")
  println()

  val otherList = copyList.add(4)
  println(s"otherList is $otherList")
  println(s"other list comparisson: ${otherList == intList}")



}

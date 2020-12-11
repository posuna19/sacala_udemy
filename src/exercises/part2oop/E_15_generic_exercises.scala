package exercises.part2oop

import lectures.part1basics.Utils.out

object E_15_generic_exercises extends App {

  val listOfIntegers: MyList[Int] = new CustomList(1, new CustomList(2, new CustomList(3, EmptyList)))
  val strList: MyList[String] = new CustomList("str1", new CustomList("str2", new CustomList("str3", EmptyList)))

  out(listOfIntegers)
  out(strList)
}

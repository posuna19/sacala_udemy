package lectures.part3functionalprog

object E_20_Functional_programing extends App {

  println("Functional Programming")

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println("Doubles is: " + doubler(2))


  // Function types = Function1[A, B]
  val strToInt = new Function[String, Int] {
    override def apply(v1: String): Int = v1.toInt
  }


  val adder: ((Int, Int) => Int) = new Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }

  println(s"Adder is: ${adder(3,4)}")

  val concatenator: ((String, String) => String) = new Function2[String, String, String]{
    override def apply(v1: String, v2: String): String = v1 + v2
  }

  println(s"Concatenator is: " + concatenator("Functional ", "Programming"))

}


trait MyFunction[A, B] {
  def apply(element: A): B
}
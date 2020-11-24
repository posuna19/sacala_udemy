package lectures.part1basics

object E_01_ValuesVariablesTypes extends App{

  //Vals are immutable
  val  x: Int = 42
  println(x)


  val y = 55 // Type are optional

  val aStr: String = "Hello"

  println(s"The str is: $aStr")


  val aBoolean: Boolean = true
  val aBoolean2: Boolean = false

  val aChar: Char = 'a'
  val aShort: Short = 22
  val aLong: Long = 344L
  val aFloat: Float = 455.23f
  val aDouble: Double = 213123.232 //Defaul value representation


  // Variables

  var aVar: Int = 4

  aVar = 5 // Side effects


}

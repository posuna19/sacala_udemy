package lectures.part1basics

import Utils.out

object E_07_Default_Args extends App {

  out("Default arguments and named arguments")

  def tailRecursiveFactorial(n: Int, acc: Int = 1): Int = {
    if(n <= 1)
      acc
    else
      tailRecursiveFactorial(n - 1, n * acc)
  }

  val fac5 = tailRecursiveFactorial(10, 1)
  val fac10 = tailRecursiveFactorial(10) // optional parameter not specified

  out(s"The factorial of 5 is $fac5")
  out(s"The factorial of 10 is $fac10")


  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = {
    out(s"Saving pic, values are: format=$format, width=$width, height=$height")
  }

  savePicture() // No parameters because all are optional
  savePicture(width = 800) // Only one parameter
  savePicture(height = 600, width = 500, format = "png") // all parameters in different order


}

package lectures.part1basics

import Utils.out

object E_02_Expressions extends App {

  val x = 1 + 2 // Expression
  println(x)

  println( 2 + 3 * 4)

  out()
  println("Math Operators: ")
  println("+ - * / % & | ^ << >> >>> (right shift with zero extension)")

  out()
  out("Relational Operators")
  out("== != > >= < <= ===")
  out((1 == x).toString)


  out()
  out("Logical Operators")
  out(" ! && ||")


  // Instructions (DO) vs Expressions (Value or Type)

  // If expression returns a value
  out()
  out("Expressions and Instructions")
  val aCondition: Boolean = true

  val aConditionValue = if(aCondition) 5 else 3 // It returns a value

  out(aConditionValue.toString)

  out()
  out("An instruction is: Do something")
  out("An expression is: give me the value of something")

  //While loops should be avoided
  out()
  out("While loops should be avoided")
  var i = 0

  while(i < 5) {
    out(i.toString)
    i += 1
  }

  var aVariable = 4

  out("Everything in Scala is an expression")
  val aWeirdValue = (aVariable = 3) // Unit === void


  // A side effects in scala is any Expression that returns
  // a Unit as a return type
  // Examples of side effects are: println, whiles, reasigning

  out()
  out("Code block")
  out("Code block are expression")
  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if(z > 2) "hello" else "goodbye" // This is the last sentence states the type
  }

  out(s"The code block value is: $aCodeBlock")
  out(s"In scala you should think more in term of expressions and vals")




}

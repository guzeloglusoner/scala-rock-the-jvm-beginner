package lectures.part1basics

object Expressions extends App {

  val x = 1 + 2 // EXPRESSION
  println(x)

  println(2 + 3 * 4)
  // + - * / & | ^ << >> >>> (right shift with zero extension)

  println(1 == x)
  // == != > >= < <=

  println(!(1 == x))
  // ! && ||

  var aVariable = 2
  aVariable += 3 // also works -= += /= ...side effects
  println(aVariable)

  // Instructions(DO STH) vs Expressions (GIVE ME VALUE OF STH)

  // IF expression
  val aCondition = true
  val aConditionedValue = if (aCondition) 5 else 3 // IF EXPRESSION
  println(aConditionedValue)
  println(if (aCondition) 5 else 3)
  println(1 + 3)

  // NEVER WRITE THIS AGAIN.
  var i = 0
  val aWhile: Unit = while (i < 10) {
    println(i)
    i += 1
  }



  // EVERYTHING in Scala is an Expression!
  val aWeirdValue = (aVariable = 3) //Unit === void
  println(aWeirdValue)
  // SIDE EFFECTS in scala are expressions returning unit

  // Side effects: println(), whiles, reassigning


  // Code Blocks are expression & Value of a code block is the last expression of the block.

  val aCodeBlock = {
    val y = 2
    val z = y + 1 // not visible.

    if (z > 2) "hello" else "goodbye"
  }

  //  1. difference between "hello world" vs println("hello world") ?
  //  a.1 hello world is an immutable string, println("hello world") is Unit(Side effect)

  val someValue: Boolean = { // Boolean
    2 < 3
  }

  val someOtherValue: Int = { //INT
    if(someValue) 239 else 986
    42
  }
}

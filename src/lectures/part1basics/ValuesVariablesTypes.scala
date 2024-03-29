package lectures.part1basics

object ValuesVariablesTypes extends App {
  val x: Int = 42
  println(x)

  // VALS ARE IMMUTABLE

  // Compiler can infer types

  val aString: String = "hello"
  val anotherStr = "goodbye"

  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val anInt: Int = x
  val aShort: Short = 4655
  val aLong: Long = 5465465654654654L
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  // variables
  var aVariable: Int = 4
  aVariable = 5 // Side effects....
}

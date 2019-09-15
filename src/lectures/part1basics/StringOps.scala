package lectures.part1basics

object StringOps extends App {

  val str: String = "Hello, I am learning Scala"

  println(str.charAt(2))
  println(str.substring(7,11)) /*inclusive, exclusive*/
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase, str.toUpperCase())
  println(str.length)

  val aNumberString = "2"
  val aNumber = aNumberString.toInt
  println('a' +: aNumberString :+ 'z')
  println(str.reverse)
  println(str.take(2))

  // Scala-specifi: String Interpolators

  // S-interpolator

  val name = "david"
  val age = 12
  val greeting = s"hello , my name is $name, I am $age years old"
  val anotherGreeting = s"hello , my name is $name, I will be turning ${age + 1}"
  println(anotherGreeting)

  // F-interpolatores
  val speed = 1.2f
  val myth = f"$name%s can eat $speed%2.2f burgers per minute"
  println(myth)

  // raw-interpolators
  println(raw"This is a \n newLine") //--> put raw to ignore \n
  val escaped = "This is a \n newLine"
  println(raw"$escaped")
  println("This is a \n newLine")

}

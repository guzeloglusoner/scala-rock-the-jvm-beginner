package lectures.part4pm

/**
  * Created by soner.guzeloglu onn 23.07.2019
  */
object PatternsEverywhere extends App {

  // big idea #1

  try {
    // code
  } catch {
    case e: RuntimeException => "Runtime"
    case npe: NullPointerException => "npe"
    case _ => "sth else"
  }

  // catches are actually matches

  /**
    * try {
    * code
    * } catch(e){
    * e match {
    * case e:.....
    *
    * }
    *
    *
    * }
    */


  // big idead #2
  val list = List(1, 2, 3, 4)
  val evenOnes = for {
    x <- list if x % 2 == 0
  } yield 10 * x

  // generators are also based on PM

  val tuples = List((1, 2), (3, 4))
  val filterTuples = for {
    (f, s) <- tuples
  } yield f + s

  // case classes, :: operators, ...

  // big idea #3
  val tuple = (1, 2, 3)
  val (a, b, c) = tuple
  // multiple value definitions based on PM
  // ALL THE POWER

  val head :: tail = list
  println(tail)

  // big idea #4 - NEW
  // partial function based on Pattern Matching

  val mappedList = list.map {
    case v if v % 2 == 0 => v + " is even"
    case 1 => "the one"
    case _ => "sth else"
  } // partial function literal

  val mappedList2 = list.map { x =>
    x match {
      case v if v % 2 == 0 => v + " is even"
      case 1 => "the one"
      case _ => "sth else"
    }
  }
  println(mappedList)
}

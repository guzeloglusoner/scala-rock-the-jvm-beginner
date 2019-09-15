package lectures.part4pm

import exercises.{Cons, Empty, MyList}

/**
  * Created by soner.guzeloglu onn 23.07.2019
  */
object AllThepatterns extends App {

  // 1- constants
  val x: Any = "Scala"
  val constants = x match {
    case 1 => "a number"
    case "Scala" => "The Truth"
    case AllThepatterns => "A singleton object"
  }

  // 2- match anything
  // 2.1 wildcard

  val matchAnything = x match {
    case _ =>
  }

  //  2.2 variable
  val matchAVariable = x match {
    case something => s"I've found $something"
  }
  // 3 - tuples
  val aTuple = (1, 2)
  val matchATuple = aTuple match {
    case (1, 1) =>
    case (something, 2) => s"I've found $something"
  }

  val nestedTuple = (1, (2, 3))
  val matchANestedTyple = nestedTuple match {
    case (_, (2, v)) =>
  }

  // PMs can be NESTED!

  // 4 - case classes - constructor pattern
  // PMs can be nested with CCs as well
  val aList: MyList[Int] = Cons(1, Cons(2, Empty))
  val matchAList = aList match {
    case Empty =>
    case Cons(head, Cons(subhead, subtail)) =>
  }

  // 5 - list pattern
  val aStdList = List(1, 2, 3, 42)
  val stdListMatching = aStdList match {
    case List(1, _, _, _) => //extractor --advanced
    case List(1, _*) => // List of arbitrary length - advanced
    case 1 :: List(_) => //infix pattern
    case List(1, 2, 3) :+ 42 => // infix pattern

  }


  // 6- type specifiers
  val unkown: Any = 2
  val unkownMatch = unkown match {
    case list: List[Int] => // explicit type specifier
    case _ =>
  }

  // 7 -name binding
  val nameBindingMatch = aList match {
    case nonEmptyList @ Cons(_,_) => // name binding => use the name later(here)
    case Cons(1, rest @ Cons(2, _)) => // name binding inside nested patterns
  }

  // 8 - multi patterns

  val multipattern = aList match {
    case Empty | Cons(0 , _) => // compound pattern
  }

  // 9 - if guards

  val secondElementSpecial = aList match {
    case Cons(_, Cons(specialElement, _ )) if specialElement % 2 == 0 =>
  }

  /*
  *
  *
  * */

  val numbers = List(1,2,3)
  val numbersMatch = numbers match {
    case listOfStrings: List[String] => "a list of strings"
    case listOfNumbers: List[Int] => "a list of numbers"
    case _ => ""
  }

  println(numbersMatch) // a list of strings!!!!!
  // JVM trick question JAVA 9 can be run in JAVA 1. Generics is not exists since JAVA 5. This is the reason.



}

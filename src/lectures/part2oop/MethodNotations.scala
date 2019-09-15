package lectures.part2oop

/**
  * Created by soner.guzeloglu onn 4.07.2019
  */

object MethodNotations extends App{

  class Person(val name: String, favMovie: String, val age: Int = 0) {
    def likes(movie:String): Boolean = movie == favMovie
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(nickName: String):Person = new Person(name + " ("+ nickName+")",favMovie)
    def unary_+ : Person = new Person(name, favMovie, age + 1)
    def unary_! : String = s"$name, what the heck!"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, My name is $name and I like $favMovie"
    def apply(n: Int): String = s"$name watched LOTR $n times"
    def learns(lesson: String): String = s"$name learns $lesson"
    def learnScala(): String = learns("Scala")
  }


  val mary = new Person("Mary", "LOTR")
  println(mary.likes("Inception"))
  println(mary likes "LOTR") // infix notation = operator notation (Method with one parameter can be used like that.) // Syntactic Sugar!!!

  // "Operators" in scala
  val tom = new Person("Tom", "Fight Club")
  println(mary + tom)
  println(mary.+(tom))

  println(1 + 2)
  println(1.+(2))

  // ALL OPERATORS ARE METHODS
  // Akka Actors have ! ?


  // Prefix Notation
  // unary operators are actually method with unary_ prefix
  val x = -1 // equivalent with 1.unary_-
  val y = 1.unary_-
  // unary_ prefix only works with + - tilda !
  println(!mary)
  println(mary.unary_!)


  // postfix notations
  println(mary.isAlive)
  println(mary isAlive)

  //apply
  println(mary.apply())
  println(mary()) // equivalent


  /*
  * 1. Overload the + operator receives String => mary + "the rockstar" => new Person "Mary (the rockstar)"
  *
  * 2. Add an age to the Person class
  *    Add a unary + operator => new Person with age + 1
  *
  * 3. Add a "learns" method in the Person class => "Mary learns Scala"
  *    Add a learnsScala method, calls the learns method with "Scala".
  *    Use it in postfix notation
  *
  * 4. Overload the apply method
  *   mary.apply(2) => "Mary watched LOTR 2 times"
  *
  * */


  // 1.
  println((mary + "Undefeated").apply())
  // 2.
  println((+mary).age)
  // 3.
  println(mary learnScala)

  // 4.
  println(mary(5))

}

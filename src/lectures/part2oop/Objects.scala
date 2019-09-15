package lectures.part2oop

/**
  * Created by soner.guzeloglu onn 4.07.2019
  */
object Objects extends App{

  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static")

  object Person { // type + its only instance
    // "static" / class" - level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    // Factory method
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }

  class Person (val name: String){
    // Instance-level Functionality
  }

  // Companions

  println(Person.N_EYES)
  println(Person.canFly)

  // Scala object = SINGLETON INSTANCE
  val soner = Person
  val onder = Person
  println(soner == onder) // TRUE

  val mary = new Person("Mary")
  val john = new Person("John")
  println(mary == john) // FALSE

  val bobbie = Person(mary, john) // APPLY


  // SCALA APPLICATIONS = Scala Object with
  // def main(args: Array[String]): Unit


}

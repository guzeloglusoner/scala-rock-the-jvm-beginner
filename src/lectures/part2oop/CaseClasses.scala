package lectures.part2oop

/**
  * Created by soner.guzeloglu onn 5.07.2019
  */
object CaseClasses extends App {

  /*
  * equals, hashCode, toString
  * */
  case class Person(name: String, age: Int)

  //  1. class parameter are fields
  val jim = new Person("Jim ", 22)

  //  2. sensible toString
  //  equals println(instance) = println(instance.toString) // syntactic sugar
  println(jim.toString)

  //  3. equals and hashCode implemented OOTB

  val jim2 = new Person("Jim", 23)
  println(jim == jim2)

  // 4. CCs have hand copy method
  val jim3 = jim.copy(age = 121)
  println(jim3)

  // 5. CCs have companion obj
  val thePerson = Person
  val mary = Person("May", 23)

  // 6. CCs are serializible
  // Akka

//  7. CCs have extractor patterns == CCs can be used in PATTERN MATCHING

  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }


  /*
  * Expand MyList - use case classes and case objects
  * */
}

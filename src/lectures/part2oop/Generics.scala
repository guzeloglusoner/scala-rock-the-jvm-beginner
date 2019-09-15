package lectures.part2oop

/**
  * Created by soner.guzeloglu onn 4.07.2019
  */
object Generics extends App {

  class MyList[+A] {
    // user the type A
    def add[B >: A](element: B): MyList[B] = ???

    /*
    *  A = Cat
    *  B = Animal
    *  A + B = List of Animals
    * */
  }

  class MyMap[Key, Value]

  val listOfInteger = new MyList[Int]
  val stringOfInteger = new MyList[String]

  // generic methods
  // Object can not be parameterized
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfInt = MyList.empty[Int]

  // Variance problem
  class Animal

  class Cat extends Animal

  class Dog extends Animal

  // 1. yes List[Cat] extends List[Animal] => covariance
  class CovariantList[+A]

  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]

  // animalList.add(new Dog) ??? HARD QUESTION. => returns list of animals

  // 2. NO => INVARIANCE
  class InvariantList[A]

  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal] //Cat and Dog would not compile

  // 3. Hell, no! CONTRAVARIANCE
  class Trainer[-A]

  val trainer: Trainer[Cat] = new Trainer[Animal]

  // bounded types
  // class cage only accepts Animals and its subclasses
  class Cage[A <: Animal](animal: A)

  val cage = new Cage(new Dog)

  class Car

  //val newCage = new Cage(new Car) // Error:(50, 17) inferred
  // type arguments [lectures.part2oop.Generics.Car] do not conform to class Cage's type parameter bounds [A <: lectures.part2oop.Generics.Animal]

  // expand MyList to be generic


}

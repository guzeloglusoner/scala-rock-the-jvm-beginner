package lectures.part2oop

/**
  * Created by soner.guzeloglu onn 4.07.2019
  */
object Inheritance extends App {

  // Single Class Inheritance
   sealed class Animal {
    val creatureType = "wild"

    def eat = println("nomnom")
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch

  // Constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }

  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // overriding
  class Dog(override val creatureType: String) extends Animal {
    // override val creatureType: String = "domestic"
    override def eat: Unit ={
      super.eat
      println ("crunch crunch")}
  }

  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)

  // All instances of derived classes will use the overridden things whenever is possible


  // Type substitution (broad: Polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat

  // overRIDING vs overLOADING

  // super

  // Preventing overrides
  // 1. use final keyword in method signature
  // 2. final can be used with classes (can not be extended) String type is final.
  // 3. seal the class = prevents extension in other files.
}

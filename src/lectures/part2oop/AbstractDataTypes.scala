package lectures.part2oop

/**
  * Created by soner.guzeloglu onn 4.07.2019
  */
object AbstractDataTypes extends App {

  // abstract
  abstract class Animal {
    val creatureType: String = "wild"

    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"

    def eat: Unit = println("crunch crunch")
  }

  // traits
  trait Carnivore {
    def eat(animal: Animal): Unit
    val prererredMeal: String = "fresh meat"
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "croc"
    def eat: Unit = println("nomnomnom")
    def eat(animal: Animal): Unit = println(s"I'am a croc and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  // traits vs abstract classes
  // 1- traits do not have constructor parameters trait Carnivore(name: String) does not compile
//  2- multiple traits may be inherited by the same class
//  3- traits === behaviour, abstract class = "type of thing"
}

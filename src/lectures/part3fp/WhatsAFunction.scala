package lectures.part3fp

/**
  * Created by soner.guzeloglu onn 10.07.2019
  */
object WhatsAFunction extends App {

  // DREAM: use functions as first class elements
  //  problem: oop

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }
  println(doubler(2))

  //  function types = Function1[A, B] ... up to Function22
  val string2IntConverter = new Function[String, Int] {
    override def apply(v1: String): Int = v1.toInt
  }

  println(string2IntConverter("3") + 4)

  val adder: ((Int, Int) => Int) = new Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }


  //  Function types Function2[A, B, R] === (A, B) => R

  //  ALL SCALA FUNCTIONS ARE OBJECTS (INSTANCES OF CLASSES DERIVING FROM FUNC1 FUNC2 classes)

  /*
  * 1. a function which takes 2 strings and concatenates them
  * 2. go to myList implementation. transform the MyPredicate and MyTransformer into function types
  * 3. define a function which takes an int and returns another function which takes and int and returns an int
  *   - what's the type of this func
  *   - how to do it
  * */

  //  1.

  val concatString: (String, String) => String = new Function2[String,String,String] {
    override def apply(v1: String, v2: String): String = v1 + v2
  }

  val myFunc: Int => Int => Int = new Function[Int, Function1[Int, Int]] {
    override def apply(v1: Int): Int => Int = new Function1[Int, Int] {
      override def apply(v2: Int): Int = v1 + v2
    }
  }


  val concater: (String, String) => String = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + v2
  }
  println(concater("Soner", " Guzeloglu"))

  //  Function1[Int, Func1[Int,Int]]
  val superAdder: Function1[Int, Function1[Int, Int]] = new Function[Int, Function1[Int, Int]] {
    override def apply(v1: Int): Int => Int = new Function1[Int, Int] {
      override def apply(v2: Int): Int = v1 + v2
    }
  }

  // equivalent

  val superAdd = (x: Int) => (y: Int) => x + y

  val adder3: Int => Int = superAdder(3)
  println(adder3(4))
  println(superAdder(3)) // curried function


}

/* At most what JVM and OOP can do*/
trait MyFunction[A, B] {
  def apply(element: A): B = ???
}

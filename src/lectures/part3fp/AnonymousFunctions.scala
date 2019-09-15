package lectures.part3fp

/**
  * Created by soner.guzeloglu onn 10.07.2019
  */
object AnonymousFunctions extends App {


  /**
    * DOUBLER1  => Functional way
    * DOUBLER2 => still oop
    * val doubler2 = new Function1[Int, Int] {
    * override def apply(v1: Int): Int = v1 * 2
    * }
    * DOUBLER1 === DOUBLER2
    **/
  // Anonymous function (LAMBDA)
  val doubler1: Int => Int = x => x * 2
  val doubler2 = (x: Int) => x * 2

  // multiple params in lambda
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  // no params
  val justDoSth: () => Int = () => 3

  println(justDoSth)  // function: lectures.part3fp.AnonymousFunctions$$$Lambda$9/537548559@34ce8af7
  println(justDoSth()) //  call: 3

  // curly braces with lambdas
  val stringToInt = { (str: String) =>
    str.toInt
  }

  // MORE syntactic sugar
  val niceIncrementer: Int => Int = _ + 1 // equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _ // equivalent to (a,b) => a + b

  /*
  * 1. MyList: replace all FunctionX calls with lambdas
  * 2. Rewrite the "special" adder as an anonymous function
  *
  * */

  val specialAdder = (x: Int) => (y: Int) => x + y
  val specialAdder2: Int => Int => Int = a => b => a + b
// specialAdder === specialAdder2
  println(specialAdder2(3)(4))













  val superAdd = (x: Int) => (y: Int) => x + y
  println(superAdd(3)(4))

}

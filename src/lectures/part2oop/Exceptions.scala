package lectures.part2oop

/**
  * Created by soner.guzeloglu onn 5.07.2019
  */
object Exceptions extends App {

  val x: String = null
  //println(x.length)
  // this ^^ will crach with a NPE
  // throwing and catching exceptions

  //val aWeirdValue: String = throw new NullPointerException

  // throwable classes extend the Throwable class
  // Exception and Error are the major Throwable subtypes

  // 2. how to catch exceptions

  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No int for you")
    else 42

  val potentialFail: Int = try {
    getInt(true)
  } catch {
    case e: RuntimeException => 43
  } finally {
    // code that will be executed NO MATTER WHAT
    // optional
    // finally does not influence the return type of this expression
    // use finally only for side effects
    println("finally")
  }

  println(potentialFail)

  /*//  3. how to define your own exceptions
    class MyException extends Exception
    val exception = new MyException
    throw exception*/


  /*
  * 1. Crash your program with and OutOfMemoryError
  * 2. Crash with SOError
  * 3. PocketCalculator
  *   -add(x,y)
  *   -substract(x,y)
  *   -multpily(x,y)
  *   -divide(x,y)
  *   Throw
  *     - OverflowException if add(x,y) exceed Int.MAX_VALUE
  *     - UnderFlowException if substract(x,y) exceed Int.MIN_VALUE
  *     - MathCalculationException for division by 0
  *
  * */

  // OOM
  //val array = Array.ofDim(Int.MaxValue)

  // SO
  //  def infinite: Int = 1 + infinite
  //  val noLimit = infinite
  class OverFlowException extends RuntimeException

  class UnderFlowException extends RuntimeException

  class MathCalculationException extends RuntimeException
  object PocketCalculator {
    def add(x: Int, y: Int) = {

      val result = x + y
      if (x > 0 && y > 0 && result < 0) throw new OverFlowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderFlowException
      else result
    }

    def subtract(x: Int, y: Int) = {

      val result = x - y
      if (x > 0 && y < 0 && result < 0) throw new OverFlowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderFlowException
      else result
    }

    def multiply(x: Int, y: Int) = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverFlowException
      else if (x < 0 && y < 0 && result < 0) throw new OverFlowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderFlowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderFlowException
      else result
    }

    def divide(x: Int, y: Int) = {
      if(y == 0) throw new MathCalculationException
      else x / y
    }
  }


  println(PocketCalculator.divide(2, 0))

}

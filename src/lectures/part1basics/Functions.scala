package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  // Calling a function is an expression
  println(aFunction("hello", 3))

  def aParamlessFunction(): Int = 42

  println(aParamlessFunction())
  println(aParamlessFunction)

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }

  println(aRepeatedFunction("hello", 3))


  // WHEN YOU NEED LOOPS, USE RECURSION
  //YOU CAN LEAVE A FUNCTION WITHOUT RETURN TYPE BUT NOT FOR RECURSIVE FUNCTIONS

  def aFunctionWithSideEffect(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n - 1)
  }

  /*
  *   1. A greeting function (name,age) => "Hi, my name is $name and I am $ age years old"
  * */

  def greeting(name: String, age: Int) = s"Hi, my name is $name and I am $age years old"

  /*  2. Factorial function 1 * 2* 3* n */

  def factorial(n:Int): Int = {
    if (n <= 0)
      1
    else
      n * factorial(n - 1)
  }

  /* 3. Fibonaccci of n */

  def fibbo(n: Int): Int = {
    if(n <= 2)
      1
    else
      fibbo(n - 1) + fibbo(n - 2)
  }

  println(greeting("Soner",26))
  println(factorial(5))
  println(fibbo(5))

  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t-1)

    isPrimeUntil(n / 2)
  }
  println(isPrime(37))
  println(isPrime(2003))
  println(isPrime(37*17))

  // Int + String = String
}

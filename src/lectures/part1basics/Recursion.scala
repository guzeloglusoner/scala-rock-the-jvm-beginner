package lectures.part1basics

import java.util.concurrent.atomic.DoubleAccumulator

import scala.annotation.tailrec

object Recursion extends App {
  def factorial(n: Int): Int =
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + "I first need factorial of " + (n - 1))
      val result = n * factorial(n - 1)
      println("Computed factorial of " + n)
      result
    }

  //println(factorial(5000))

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator)

    factHelper(n, 1) // TAIL RECURSIVE = use recursive call as the LAST expression
  }

  //println(anotherFactorial(5000))

  // WHEN YOU NEED LOOPS USE TAIL RECURSION
  // 1. Concatenate a string n times
  @tailrec
  def concatStr(str: String, n: Int, accumulator: String): String =
    if (n <= 1) accumulator
    else concatStr(str, n - 1, str + accumulator)

  println(concatStr("hello", 3, ""))

  // 2. IsPrime Function Tail Recursion
  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeUntil(t: Int, accumulator: Boolean): Boolean =
      if (!accumulator) false
      else if (t <= 1) true
      else isPrimeUntil(t - 1, n % t != 0 && accumulator)

    isPrimeUntil(n / 2, true)
  }

  println(isPrime(2003))
  // 3. Tail Rec Fibbo


  def fibbo(n: Int): Int = {
    @tailrec
    def tailFibbo(i: Int, last: Int, nextToLast: Int): Int =
      if (i >= n) last
      else tailFibbo(i + 1, last + nextToLast, last)

    if (n <= 2) 1
    else tailFibbo(2, 1, 1)
  }

  println(fibbo(8))
}

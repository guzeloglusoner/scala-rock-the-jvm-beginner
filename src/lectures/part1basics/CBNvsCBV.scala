package lectures.part1basics

object CBNvsCBV extends App {

  def calledByValue(x: Long): Unit = {
    println("by value:" + x)
    println("by value:" + x)
  }

  def calledByName(x: => Long): Unit = {
    println("by name:" + x)
    println("by name:" + x)
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  /*
  *
    by value:268160145758045 ---> calling by value-->  calledByValue(268160145758045) value is computed before call. Same value used everywhere
    by value:268160145758045
    by name:268160302351915 ----> calling by name----> calledByName(System.nanoTime()) param: => Int --> passed literally, evaluated at every use within
    by name:268160302455372
  * */


  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  printFirst(infinite(),34) //----> STACKOVERFLOW"

  printFirst(34, infinite()) // -----> No problem because infinite didn't evaluated.

}

package lectures.part2oop

import java.sql

import playground.{PrinceCharming, Cindirella => Princess}
import java.util.Date
import java.sql.{Date => sqlDate}
/**
  * Created by soner.guzeloglu onn 5.07.2019
  */
object PackingAndImports extends App {

  // package members are accesible by their simple name
  val writer = new Writer("Daniel", "Soner", 2019)

  //import the package
  val princess = new Princess // fully qualified name playground.Cindirella //

  // packages are in hierarchy
  // matching folder structure

  //  package object
  sayHello
  println(SPEED_OF_LIGHT)

  // imports
  val prince = new PrinceCharming

//   use fully qualified name
  val date = new Date
  val sqlDate = new sqlDate(2019,5,3)
  // 2. use alising


  // default import
  // java.lang - String Object, Exception
  // scala - Int, nothing, Function
  // scala.Predef - println, ???
}

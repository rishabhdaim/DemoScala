package com.rambabu

/**
  * Created by diam on 5/18/2018.
  */
object PartialFunctionExample extends App {

  def increment: PartialFunction[Int, Int] = {
    case x:Int => x + 1
  }

  def division: PartialFunction[(Int, Int), Int] = {
    case (n:Int, d:Int) if d != 0 => n/d
  }

  def greet: PartialFunction[String, Unit] = {
    case (n:String) => println("Hello " + n)
  }

  println(increment(10))
  println(division(1,1))
//  println(division(1,0))
  println(division.isDefinedAt(1,0))
  greet("Daim")
}

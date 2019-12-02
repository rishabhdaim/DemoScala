package com.journaldev.closures

/**
  * Created by diam on 5/13/2018.
  */
object Currying extends App {

  def multiply(a:Int, b:Int) : Int = a * b

  // no convert this method to method with one parameter with currying
  def multiple(a:Int) = (b:Int) => a * b

  println(multiply(12, 23))
  println(multiple(12))
  println(multiple(12)(23))
}

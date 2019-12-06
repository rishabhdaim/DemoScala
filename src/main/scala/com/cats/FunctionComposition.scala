package com.cats

object FunctionComposition extends App {

  def mul2: Int => Int = _ * 2

  def power2: Int => Double = Math.pow(_, 2)

  def doubleToInt: Double => Int = _.toInt

  def intToString: Int => String = _.toString

  def pipeline: Int => String = intToString compose doubleToInt compose power2 compose mul2

  println(pipeline(3))

}

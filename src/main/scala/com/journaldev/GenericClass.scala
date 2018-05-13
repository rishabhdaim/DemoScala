package com.journaldev

/**
  * Created by diam on 5/13/2018.
  */
object GenericClass extends App {

  sealed abstract class Multiply[X] {
    def multiply(a:X, b:X): X
  }

  class IntMultiply extends Multiply[Int] {
    override def multiply(a: Int, b: Int): Int = a * b
  }

  class DoubleMultiply extends Multiply[Double] {
    override def multiply(a: Double, b: Double): Double = a * b
  }

  val intMultiply = new IntMultiply
  val doubleMultiply = new DoubleMultiply

  println(intMultiply.multiply(12, 23))
  println(doubleMultiply.multiply(12.24, 23.45))
}

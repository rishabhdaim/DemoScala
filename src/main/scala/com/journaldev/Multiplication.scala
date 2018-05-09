package com.journaldev

/**
  * Created by diam on 5/8/2018.
  */
object Multiplication extends App {

  val multiplication:Multiplication = new Multiplication(45)

  println("Multiplication result of two numbers is : "+multiplication.multiply(20,21))
  println("Minimum number of 3 numbers is : "+multiplication.min(20,21, 22))

  // closure example
  println( "Divided value = " + multiplication.divider(4) )
  println( "Divided value = " + multiplication.divider(6) )
  println( "Divided value = " + multiplication.divider(8) )
  println( "Divided value = " + multiplication.divider(10) )

  multiplication.totalMarks(0)
  println("Result is: " + multiplication.result(6))
  println("Result is: " + multiplication.result(12))
  println("Result is: " + multiplication.result(123))

}

class Multiplication(m1: Int) {

  var marks: Int = m1

  def multiply(a:Int, b:Int) : Int = {
    val c:Int = a * b
    return c
  }
  println("Multiplication result of two numbers from class is : "+multiply(20,21))

  // nested functions
  def min(x:Int, y:Int, z:Int) : Int = {
    def min(i:Int, j:Int) : Int = {
      if (i < j) i
      else j
    }
    min(x, min(y, z))
  }

  var div = 2
  var divider = (i:Int) => {
    div = 4
    i/div
  }
  div = 3

  def totalMarks(m:Int) : Unit = {
    marks = marks + 10
    println("Total marks secured: " +marks)
  }

  val result = (i:Int) => i * 6
}
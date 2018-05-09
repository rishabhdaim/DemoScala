package com.journaldev

/**
  * Created by diam on 5/9/2018.
  */
object Tuples extends App {

  // create tuple of Int & String
  var s1: Tuple2[Int, String] = (12,"Harry")
  println(s1)

  s1 = new Tuple2[Int, String](27, "Rishu")
  println(s1)
  println(s"Tuple _1 is : ${s1._1} and _2 is ${s1._2}")

  // short hand declaration of tuple
  val m1 = (20,12,16,4)
  println(m1)
  println(s"Element of m1 are : ${m1._1}, ${m1._2}, ${m1._3}, ${m1._4}")
  val mul = m1._1 * m1._2 * m1._3 * m1._4
  println(s"Multiplication is : $mul")

  val names = ("John","Smith","Anderson","Steve","Rob")
  names.productIterator.foreach(i => println(s"Value is : $i"))

  // swap method, only available for Tuple2
  val id = (12, 34)
  println(s"ID is : $id")
  println(s"ID swapped is : ${id.swap}")

  val student = new Tuple3(12, "Rob", "IT")
  println("Concatenated String: " + student.toString())
  println("Concatenated String: " + student)
}

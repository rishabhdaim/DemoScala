package com.rambabu

/**
  * Created by diam on 5/19/2018.
  */
object Arrays extends App {

  val myIntArray: Array[Int] = Array(10,2,30,33,12,1,17)
  println(myIntArray)

  // lazy evaluation
  val lazzy: Seq[(Int, Int)] = for ((index, value) <- myIntArray.view.zipWithIndex) yield (index, value)
  println(lazzy)
  println(lazzy(4))
  println("-------------------")
  for ((index, value) <- myIntArray.view.zipWithIndex) println(value, index)
  println("-------------------")
  // eager evaluation
  val eager: Seq[(Int, Int)] = for (i <- Range(0, myIntArray.length)) yield (i, myIntArray(i))
  println(eager)
}

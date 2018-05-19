package com.rambabu

/**
  * Created by diam on 5/19/2018.
  */
object Sets extends App {

  val set1:Set[String] = Set()
  println(set1)
  println(set1.getClass)

  // concatenate 2 sets
  val set2: Set[Int] = Set(1,2,3,4,5)
  val set3: Set[Int] = Set(6,7,8,4,5)
  val set4: Set[Int] = set2 ++ set3
  println(set4)

  // check element
  println(set4.contains(0))
  println(set4(0))
  println(set4(5))

  // head & tail
  println(set4.head)
  println(set4.tail)

  val set5: Set[Int] = set4 + 9
  println(set5)
}

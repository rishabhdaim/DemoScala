package com.rambabu

/**
  * Created by diam on 5/19/2018.
  */
object Lists extends App {

  // emptyList
  var emptyList: List[Int] = List()
  println(emptyList)

  // add element on beginning og list
  var list = 1 :: emptyList
  println(list)

  list = 2 :: list
  println(list)

  list = 4 +: list
  println(list)

  // add element at end
  list = list :+ 3
  println(list)
  // sort list
  val list1 = list.sorted
  println(list1)

  // create new list using companion object
  val list2 = List(10,11,12,13,14)
  println(list2)

  // concatenate 2 lists
  val fullList = list1 ++ list2
  println(fullList)

  // map function
  println(fullList.map(i => i + 1))
  println(fullList.map{_ * 2})

}

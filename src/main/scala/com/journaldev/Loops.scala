package com.journaldev

/**
  * Created by diam on 5/9/2018.
  */
object Loops extends App {

  var sid:Int = 0
  var marks:Int = 60
  val marksList = List(60,65,70,75,80,85);
  val idList = List(4,5,6,7,8,9,10,11,12);
  //for loop with ranges
  for (sid <- 6 to 12) println(s"SID is: $sid")

  // for loop with until
  for (sid <- 10 until 20) println(s"SID is: $sid")

  // multiple/nested for loops
  for (sid <- 1 to 2; marks <- 50 to 52) println(s"SID is: $sid and marks are: $marks")

  // for loop with collections
  for (i <- marksList) println(s"Marks are: $i")

  // for loop with conditions
  for (i <- idList if i != 11; if i > 6) println(s"ID is: $i")

  // for loop with yield
  var result = for( id <- idList if  id < 9; if id !=7) yield id
  println(result)
}

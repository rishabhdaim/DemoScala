package com.journaldev.types

/**
  * Created by diam on 5/13/2018.
  */
class Adam extends Student {

  type X = Int

  override def totalMarks(m1: Int, m2: Int) = m1 + m2

  val age = 7

  val name:String = "Rishu"

  var marks:Int = 59
}

object Adam extends App {
  val adam = new Adam
  println(adam.totalMarks(23, 45))

  // pre-initialized fields
  val studentPercent: StudentPercent = new {
    val obtained = 50
    val total = 100
  } with StudentPercent

  println(studentPercent)
}

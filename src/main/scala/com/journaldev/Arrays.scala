package com.journaldev

import Array._

/**
  * Created by diam on 5/9/2018.
  */
object Arrays extends App {
  var student: Array[String] = new Array[String](5)
  println(student)

  student = new Array[String](10)
  println(student)

  student = Array("Rishu", "Anku", "Munna", "Aru", "Deep")
  println(student)

  for(s <- student) println(s"Name is: $s")
  for (s <- 0 to (student.length - 1)) println(s"Name : ${student(s)}")

  // multi dimensional array
  val rows:Int = 2
  val cols:Int = 3
  val mulDim = ofDim[String](rows, cols)
  mulDim(0)(0) = "Reena"
  mulDim(0)(1) = "John"
  mulDim(0)(2) = "Adam"
  mulDim(1)(0) = "Michael"
  mulDim(1)(1) = "Smith"
  mulDim(1)(2) = "Steve"

  for (i <- 0 until rows; j <- 0 until cols) println(s"($i)($j) = ${mulDim(i)(j)}")

  var sname = Array("John","Adam","Rob","Reena","Harry")
  var sname1 = Array("Jack","Jill","Henry","Mary","Rohan")

  var names = concat(sname, sname1, student)
  println(s"Size is: ${names.size}")
  for (s <- names) println(s"Names are: $s")

  var id = range(7, 23, 3)
  var age = range(15,20)
  for ( s <- id ) {
    print( " " + s)
  }
  println()
  for ( a <- age ) {
    print( " " + a )
  }
}

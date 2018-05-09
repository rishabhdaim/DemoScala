package com.journaldev

/**
  * Created by diam on 5/10/2018.
  */
object Maps extends App {

  val student:Map[Int, String] = Map(12 -> "Reena", 13 -> "Micheal" , 14 -> "Peter")
  println(student)

  val marks: Map[String, Int] = Map()
  println("Keys : " + student.keys)
  println("Values : " + student.values)
  println("Check if student is empty : " + student.isEmpty)
  println("Check if marks is empty : " + marks.isEmpty)

  // concat
  val stud1 = Map(12 -> "Reena", 13 -> "Micheal" , 14 -> "Peter")
  val stud2 = Map(15 -> "Russel", 16 -> "Mark" , 17 -> "Steve")

  var stud = stud1 ++ stud2
  println( "stud1 ++ stud2 : " + stud)

  val stu = stud1.++(stud2)
  println( "stud1.++(stud2)) : " + stu)

  // foreach example
  stud.keys.foreach{i =>
    print(s"Key is : $i")
    println(s" Value is : ${stud(i)}")
  }

  println("------------------------------------")
  println("------------------------------------")

  // '-' : to remove keys from Map
  stud = stud.-(12, 13)
  stud.keys.foreach{i =>
    print(s"Key is: $i")
    println(s"Value is: ${stud(i)}")
  }
}

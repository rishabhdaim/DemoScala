package com.journaldev

/**
  * Created by diam on 5/8/2018.
  */
object PatternMatch extends App {

  println(studAgematch(7))
  println(studAgematch(5))
  println(studAgematch(12))

  println(matchAge("eight"))
  println(matchAge("twelve"))
  println(matchAge(7))
  println(matchAge(9))

  def studAgematch(age:Int) : String = age match {
    case 5 => "Student Age is 5 "
    case 7 => "Student Age is 7"
    case 8 => "Student Age is 8"
    case 10 => "Student Age is 10"
    case _ => "Student age is greater than 10"
  }

  def matchAge(age: Any): Any = age match {
    case 7 => "Age is Seven"
    case "eight" => 8
    case y: Int => "Age is greater than 7"
    case _ => "Age is greater than 10"
  }

  val st1 = new Student(1,"Adam", 12)
  val st2 = new Student(2,"John", 9)
  val st3 = new Student(3,"Reena", 16)
  val st4 = new Student(4,"Anku", 25)

  for (st <- List(st1, st2, st3, st4)) {
    st match {
      case Student(1,"Adam", 12) => println("Hello Adam")
      case Student(3,"Reena", 16) => println("Hello Reena")
      case Student(id, name, age) =>
        println("Id: " + id + " Age: " + age + " Name: " + name)
    }
  }

  // case class have overridden toString method
  println(st4)

  // student case class
  case class Student(id:Int, name: String, age: Int)
}

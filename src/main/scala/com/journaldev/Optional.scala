package com.journaldev

/**
  * Created by diam on 5/10/2018.
  */
object Optional extends App {

  // Option with some value
  val msg : Option[String] = Some("Option is a Scala collection")

  // option with no value
  val noMsg : Option[String] = None

  case class Student(id:Int, name:String, marks:Float, gender:Option[String])

  val optional = new Optional
  val st1 = optional.findById(2)
  printStudent(st1)
  displayKey(st1)
  println("---------------------------------")
  val st2 = optional.findById(3)
  printStudent(st2)
  displayKey(st2)
  println("---------------------------------")
  st2.foreach(optional.display)

  val st3 = optional.findById(400)
  println(s"Student with ID 400 is not present : ${st3.isEmpty}")
  println(s"Student with ID 400 is : ${st3.orNull}")
  println(s"Student with ID 400 is : ${st3.foreach{s =>
    println(s.id)
    println(s.name)
    println(s.marks)
    println(s.gender.getOrElse("Gender Not Defined"))
  }}")

  //GetOrElse
  private def printStudent(student: Option[Student]): Unit = {
    if (student.isDefined) {
      println(student.get.id)
      println(student.get.name)
      println(student.get.marks)
      println(student.get.gender.getOrElse("Gender Not Defined"))
    }
  }

  private def displayKey(student: Option[Student]): Unit = {
    student match {
      case Some(s) =>
        println(s"ID : ${s.id}")
        println(s"Name : ${s.name}")
        println(s"Marks : ${s.marks}")
        s.gender match {
          case Some(gender) => println(s"Gender : ${gender}")
          case None => println("No Gender")
        }
      case None =>
    }
  }


}

class Optional {
  private val students: Map[Int, Optional.Student] = Map(1 -> Optional.Student(10, "John", 62.5f, Some("male")),
    2 -> Optional.Student(12, "Adam", 70.5f, Some("female")),
    3 -> Optional.Student(14, "Chris", 45f, None)
  )
  def findById(id: Int): Option[Optional.Student] = students.get(id)
  def findAll = students.values

  val display = (s:Optional.Student) => {
    println(s.id)
    println(s.name)
    println(s.marks)
    println(s.gender.getOrElse("Gender Not Defined"))
  }
}

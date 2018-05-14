package com.journaldev.casse.classes

/**
  * Created by diam on 5/15/2018.
  */
case class Person(name:String, age:Int)

object TestPerson extends App {
  val person = Person("Rishu", 27)
  println(person)
  println(person.name)
  println(person.age)

  // copy method

  val person2 = person.copy(name = "Ankit", age = 25)
  println(person2)
}

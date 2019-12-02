package com.alvinalexander

import scala.util.Try

case class Config(name: String, age: Int)
case class Age(age: Int)
case class Name(first: String, last: String)
case class Person(name: Name, age: Age)

object Imperative {

  def readName(implicit config: Config): Name = {
    val parts = config.name.split(" ")
    require(parts.length >= 2)
    Name(parts(0), parts.tail.mkString(" "))
  }

  def readAge(implicit config: Config): Age = {
    val age = config.age
    require(1 <= age && age <= 150)
    Age(age)
  }

  def readPerson(implicit config: Config): Option[Person] = {
    Try(Some(Person(readName, readAge))).getOrElse(None)
  }

  def main(args: Array[String]): Unit = {
    println(readPerson(Config("Rishabh Daim", 28)))
    println(readPerson(Config("Rishu", 28)))
  }
}

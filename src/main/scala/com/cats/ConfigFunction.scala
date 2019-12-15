package com.cats

import cats.data.Kleisli
import cats.implicits._


final case class Name(first: String, last: String)

final case class Age(age: Int)

final case class Person(name: Name, age: Age)

final case class Config(name: String, age: Int)

object ConfigFunction extends App {

  def readName: Config => Option[Name] = c => {
    val parts = c.name.split(" ")
    if (parts.length > 1) Option(Name(parts(0), parts.drop(1).mkString(" "))) else None
  }

  def readNameK = Kleisli(readName)

  def readAge: Config => Option[Age] = c => {
    val age = c.age
    if (age >= 1 && age <= 150) Option(Age(age)) else None
  }

  def readAgeK = Kleisli(readAge)

  val personK: Kleisli[Option, Config, Person] =
    for {
      name <- readNameK
      age  <- readAgeK
    } yield Person(name, age)

  //Some(Person(Name(Bojack,Horseman),Age(42)))
  val result1 = personK(Config("Bojack Horseman", 42))

  println(result1)

  //None - Name is not space-separated
  val result2 = personK(Config("Jake", 20))
  println(result2)

  //None - age is not between 1 and 150
  val result3 = personK(Config("Fred Flintstone", 50000))
  println(result3)
}

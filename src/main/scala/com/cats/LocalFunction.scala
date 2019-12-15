package com.cats

import cats.Apply
import cats.data.Kleisli
import cats.implicits._

object LocalFunction extends App {
  def readName: String => Option[Name] = name => {
    val parts = name.split(" ")
    if (parts.length > 1) Option(Name(parts(0), parts.drop(1).mkString(" "))) else None
  }

  def readAge: Int => Option[Age] = age => {
    if (age >= 1 && age <= 150) Option(Age(age)) else None
  }

  def readNameK: Kleisli[Option, String, Name] = Kleisli(readName)

  def readAgeK: Kleisli[Option, Int, Age] = Kleisli(readAge)

  var personK: Kleisli[Option, Config, Person] =
    for {
      name <- readNameK.local[Config](_.name)
      age  <- readAgeK.local[Config](_.age)
    } yield Person(name, age)

  //Some(Person(Name(Bojack,Horseman),Age(42)))
  println(personK(Config("Bojack Horseman", 42)))

  //None
  println(personK(Config("Jake", 20)))

  //None
  println(personK(Config("Fred Flintstone", 50000)))

  type KOptionConfig[A] = Kleisli[Option, Config, A]

  val config = Config("Diane Nguyen", 27)
  def readNameKOC = readNameK.local[Config](_.name)
  def readAgeKOC = readAgeK.local[Config](_.age)

  personK = Apply[KOptionConfig].map2(readNameKOC, readAgeKOC) { Person(_, _) }

  //Some(Person(Name(Diane,Nguyen),Age(27)))
  println(personK(config))
}

package com.cats

import cats.Apply
import cats.data.Kleisli
import cats.implicits._

object ApplyFunction extends App {

  type KOptionConfig[A] = Kleisli[Option, Config, A]
  type PersonFunc = (Name, Age) => Person

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

  val config = Config("mr peanutbutter", 30)
  val readNameKOC: KOptionConfig[Name] = readNameK
  val readAgeKOC: KOptionConfig[Age] = readAgeK
  val personKOC: KOptionConfig[PersonFunc] = Kleisli( (_: Config) => Option(Person(_, _)))

  //Kleisli[Option, Config, Person]
   def personK = Apply[KOptionConfig].ap2(personKOC)(readNameKOC, readAgeKOC)
   def personKMap: Kleisli[Option, Config, Person] = Apply[KOptionConfig].map2(readNameKOC, readAgeKOC) { Person(_,_) }

  //Some(Person(Name(mr,peanutbutter),Age(30)))
  println(personK(config))
  println(personKMap(config))
}

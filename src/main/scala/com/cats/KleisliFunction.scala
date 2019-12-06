package com.cats

import cats.data.Kleisli
import cats.implicits._

object KleisliFunction extends App {

  def stringToNonEmptyString: String => Option[String] = value => if (value.nonEmpty) Option(value) else None

  def stringToNonEmptyStringK = Kleisli(stringToNonEmptyString)

  def stringToNumber: String => Option[Int] = value => if (value.matches("-?[0-9]+")) Option(value.toInt) else None

  def stringToNumberK = Kleisli(stringToNumber)

  def pipeline = stringToNumberK compose stringToNonEmptyStringK

  println(pipeline("12345"))
  println(pipeline(""))
  println(pipeline("AIB2"))

  def pipeline2: String => Option[Int] = Option(_) >>= stringToNonEmptyString >>= stringToNumber

  println(pipeline2("ASV"))
  println(pipeline2("2000"))

  println(Option("2345") >>= stringToNonEmptyString >>= stringToNumber)

}

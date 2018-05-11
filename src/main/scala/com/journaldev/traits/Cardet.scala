package com.journaldev.traits

import scala.io.Source

/**
  * Created by rishabh on 11/5/18.
  */
class Cardet extends Cardetails {

  override def details(d: String): String = {
    Source.fromString(d).mkString
  }
}

object Cardet extends App {
  val c1 = new Cardet
  println(c1.details("Car details ae bieng displayed"))
  println(c1.isInstanceOf[Cardetails])
}

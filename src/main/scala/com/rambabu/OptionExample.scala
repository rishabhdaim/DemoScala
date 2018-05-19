package com.rambabu

/**
  * Created by diam on 5/19/2018.
  */
object OptionExample extends App {

  var empNo: Option[String] = Some("123456")
  println(empNo)

  // getOrElse
  empNo = None
  println(empNo.getOrElse("Not Present"))

  // map
  val empInt = empNo.map(no => no.toInt)
  println(empInt)

  // foreach
  empNo.foreach(println)

  // pattern matching
  val num = empNo match {
    case Some(no) => no.toInt
    case None => -1
  }
  println(num)

  // fold
  var empName: Option[String] = Some("Rishabh Daim")
  println(empName.fold("Unknown") {_.toUpperCase})

  empName = None
  println(empName.fold("Unknown") {_.toUpperCase})
}

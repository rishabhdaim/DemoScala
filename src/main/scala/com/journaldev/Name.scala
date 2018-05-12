package com.journaldev

/**
  * Created by diam on 5/12/2018.
  */
object Name extends App {

  println("Apply method : " + apply("Steve", "Smith"))
  println("Unapply method : " + unapply("Steve Smith").getOrElse(None))
  println("Unapply method : " + unapply("Rob"))

  def apply(fName:String, lName:String): Name = new Name(fName, lName)

  def unapply(arg: String): Option[Name] = {
    val pts = arg split " "
    if (pts.length == 2) {
      Some(Name(pts(0), pts(1)))
    } else {
      None
    }
  }
}

class Name(fName:String, lName:String) {
  def firstName: String = fName
  def lastName: String = lName

  override def toString = s"Name($firstName, $lastName)"
}

package com.journaldev.bounds.view

/**
  * Created by diam on 5/14/2018.
  */
object ScalaViewBoundsTest extends App {

  val p1 = new Person("Rams","Posa")
  val p2 = new Person("Chintu","Charan")
  val p3 = new Person("Rishabh","Daim")
  val p4 = new Person("Ankit","Daim")

  println(p1.greater)
  println(p2.greater)
  println(p3.greater)
  println(p4.greater)
}

class Person[T <% Ordered[T]](val firstName: T, val lastName: T) {
  def greater = if (firstName > lastName) firstName else lastName
}

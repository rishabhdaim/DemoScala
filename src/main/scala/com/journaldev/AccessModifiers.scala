package com.journaldev
package student
package gradstudent
/**
  * Created by diam on 5/7/2018.
  */
class AccessModifiers {
  protected[gradstudent] var degree = "B.E."
  private[student] var marks = 6.28
  private[this] val age = 27

  def studDetails(stu:AccessModifiers): Unit = {
    println(stu.degree)
    println(stu.marks)
//    can't access age since it is only available for this instance
//    println(stu.age)
  }

  def printAge = println(s"Age is : $age")
}

object AccessModifiers extends App {
  val am = new AccessModifiers
  am.studDetails(am)
  am.printAge
}

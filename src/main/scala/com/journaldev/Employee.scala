package com.journaldev

/**
  * Created by diam on 5/13/2018.
  */
class Employee (val empId:Int, val firstName:String = "Rishabh", lastName:String = "Daim") {
  def fullName(delimiter:String = " "): String = firstName + delimiter + lastName
  def id: Int = empId
}

object Employee extends App {
  var emp = new Employee(1)
  println(emp.fullName())

  emp = new Employee(2, firstName = "Ankit")
  println(emp.fullName("-"))
}

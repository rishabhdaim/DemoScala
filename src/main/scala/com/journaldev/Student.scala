package com.journaldev

/**
  * Created by diam on 4/24/2018.
  */
class Student(val m1:Int,val m2:Int) {

  var total:Int = m1 + m2
  var ma1:Int = m1
  var ma2:Int = m2

  def calculateTotal(ma1:Int,ma2:Int) {
    total = ma1 + ma2
    println("Total is :"+total)
  }
  override def toString(): String = "(" + total + ")";
}


object Student {
  def main(args: Array[String]) {
    val student = new Student(6, 8)
    student.calculateTotal(21, 23)
    println(student)
  }
}
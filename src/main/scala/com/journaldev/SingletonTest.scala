package com.journaldev

/**
  * Created by rishabh on 24/4/18.
  */
object SingletonTest {
  def say(): Unit = {
    println("Hi, Daim!!")
    // excape characters
    println("String\tLiteral\n\nData")

    val(age, name) = (27, "Rishu")
    println(s"Age : $age, Name : $name")
  }

  def main(args: Array[String]) {
    SingletonTest.say()
  }
}

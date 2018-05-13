package com.journaldev.polymorphic

/**
  * Created by diam on 5/13/2018.
  */
object Polymorphic extends App {

  def add(a:Int, b:Int) {
    val c = a + b
    println(c)
  }

  def addStrings(a:String, b:String): Unit = {
    val c = a + b
    println(c)
  }

  add(12, 23)
  addStrings("Rish", "abh")
}

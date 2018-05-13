package com.journaldev.closures

/**
  * Created by diam on 5/13/2018.
  */
object TypeDependent extends App {

  def forLoop(rule: => Boolean)(body: => Unit) : Unit = {
    if (rule) {
      body
      forLoop(rule)(body)
    }
  }

  var i = 7
  forLoop(i > 2) {
      println(s"i : $i")
      i -= 1
    }
}

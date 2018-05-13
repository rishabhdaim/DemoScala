package com.journaldev.closures

/**
  * Created by diam on 5/13/2018.
  */
object TypeDef extends App {

  def t1(body: => Unit) : Criteria = new Criteria(body)

  protected class Criteria(body: => Unit) {
    def condition(rule: => Boolean) {
      body
      if (!rule) condition(rule)
    }
  }

  var x = 7
  t1({
    println(s"X: $x")
    x -= 1
  }).condition({x == 2})

}

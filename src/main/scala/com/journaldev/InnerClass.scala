package com.journaldev

/**
  * Created by diam on 5/13/2018.
  */
object InnerClass extends App {

  val a1 = new Add
  val a2 = new Add

  val b1 = new a1.AddTwoNumbers
  val b2 = new a2.AddTwoNumbers

  println(b1.c)
  println(b2.c)

  // change b2
  b2.a = 20
  b2.b = 40
  println(b2.c)
}

class Add {
  class AddTwoNumbers {
    var a: Int = 30
    var b: Int = 50

    def c:Int = a + b
  }
}

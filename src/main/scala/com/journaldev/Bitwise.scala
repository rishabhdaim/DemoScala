package com.journaldev

/**
  * Created by diam on 5/8/2018.
  */
object Bitwise extends App {

  var x = 16
  var y = 12
  var z = 0

  z = x & y
  println("Bitwise And of x & y = " + z )

  z = x | y
  println("Bitwise Or of x | y = " + z )

  z = x ^ y
  println("Bitwise Xor of x ^ y = " + z )

  z = ~x
  println("Bitwise Ones Complement of ~x = " + z )

  z = x << 2
  println("Bitwise Left Shift of x << 2 = " + z )

  z = x >> 2
  println("Bitwise Right Shift of x >> 2 = " + z )

  z = x >>> 2
  println("Bitwise Shift Right x >>> 2 = " + z )
}

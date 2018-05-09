package com.journaldev

/**
  * Created by diam on 5/8/2018.
  */
object Assignment extends App {

  var x = 20
  var y = 30
  var z = 0

  z = x + y
  println("z= x+ y = " + z )

  z+= x 
  println("Add and assignment of z += x = " + z )

  z -= x 
  println("Subtract and assignment of z -= x = " + z )

  z *= x 
  println("Multiplication and assignment of z *= x = " + z )

  x = 20
  z = 15
  z /= x 
  println("Division and assignment of z /= x = " + z )

  x = 30
  z = 15
  z %= x
  println("Modulus and assignment of z %= x = " + z )

  z <<= 2
  println("Left shift and assignment of z <<= 2 = " + z )

  z >>= 2
  println("Right shift and assignment of z >>= 2 = " + z )

  z &= x
  println("Bitwise And assignment of z &= 2 = " +z )

  z ^= x 
  println("Bitwise Xor and assignment of z ^= x = " + z )

  z |= x 
  println("Bitwise Or and assignment of z |= x = " + z )
}

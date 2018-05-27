package book.programinscala

import java.math.BigInteger

/**
  * Created by diam on 5/24/2018.
  */
object Factorial extends App {

  def factorial(x: BigInt) : BigInt = {
    if (x == 0) 1 else x * factorial(x - 1)
  }

  def factorial(x: BigInteger) : BigInteger = {
    if (x == BigInteger.ZERO) BigInteger.ONE else x.multiply(factorial(x.subtract(BigInteger.ONE)))
  }

  println(factorial(10))
  println(factorial(BigInteger.valueOf(10)))
  println(factorial(20))
  println(factorial(BigInteger.valueOf(20)))
  println(factorial(30))
  println(factorial(BigInteger.valueOf(30)))
}

package com.marklewis

/**
  * Created by diam on 4/25/2018.
  */
object ParallelCollect extends App {

  def fib(n:Int):Int = if (n < 2) 1 else fib(n-1) + fib(n-2)

  for (i <- (25 to 10 by -1)) {
    println(fib(i))
  }

  var i:Int = 0
  for (j <- (1 to 1000000).par) {
    // load i from memory
    // add 1 to register where i is stored
    // store i back to memory
    i += 1
  }
  println(i)
}

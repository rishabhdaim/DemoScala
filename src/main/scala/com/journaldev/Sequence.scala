package com.journaldev

import scala.collection.immutable.IndexedSeq

/**
  * Created by diam on 5/13/2018.
  */
object Sequence extends App {

  private def increment(from:Int, to:Int) : List[Int] = {
    for (i <- List.range(from, to) if i % 5 == 0) yield i
  }

  println(increment(1, 40))

  // factors
  private def multiplies(x:Int, y:Int): IndexedSeq[(Int, Int)] = {
    for (a <- 0 until x; b <- a until x if a * b == y) yield Tuple2(a, b)
  }

  multiplies(42, 40) foreach {
    case (a, b) => println(s"Factors are $a, $b")
  }

  println("------------------------------")

  // without yield keyword
  for (i <- Iterator.range(0, 15); j <- Iterator.range(i, 15) if i*j == 12)
    println(s"Factors are $i, $j")

}

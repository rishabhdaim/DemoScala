package com.rambabu

/**
  * Created by diam on 5/19/2018.
  */
object Seqs extends App {

  val seq1 = Seq()
  println(seq1)
  println(seq1.getClass)

  // concatenate seq
  val seq2 = Seq(1,2,3,4)
  val seq3 = Seq(5,6,7,8)
  val seq4 = seq2 ++ seq3
  println(seq4)
  println(seq4(1))
  println(seq4(4))

  // reverse
  println(seq4.reverse)

  seq4.foreach(println)
  println(seq4.mkString(":"))
}

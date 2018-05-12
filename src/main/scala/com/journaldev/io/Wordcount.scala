package com.journaldev.io

import scala.io.Source

/**
  * Created by diam on 5/12/2018.
  */
object Wordcount extends App {

  println(Source.fromFile("build.sbt")) // return BufferedSource non-empty iterator

  private val s: String = Source.fromFile("build.sbt").mkString
  println(s)
  println(s.length)

  // splitting String data with white space and calculating the number of occurrence of each word in the file
  val counts = s.split("\\s").groupBy(x => x).mapValues(x => x.length)
  println(counts)
  println("Count of `akkaVersion,` is: " + counts("akkaVersion,"))
  println("---------------------------")

  // print line by line
  println(Source.fromFile(".gitignore").getLines())
  Source.fromFile(".gitignore").getLines.foreach{x => println(x)}

  // take some part of iterator
  println("---------------------------")
  Source.fromFile(".gitignore").getLines.take(1).foreach {x => println(x)}
  println("---------------------------")
  Source.fromFile(".gitignore").getLines.slice(1, 3).foreach {x => println(x)}
}

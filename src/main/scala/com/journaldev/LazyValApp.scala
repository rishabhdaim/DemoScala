package com.journaldev

/**
  * Created by diam on 5/15/2018.
  */
object LazyValApp extends App {
  lazy val number = { println("Constant number is initialized."); 99 }
  println("Before Accessing 'number' constant:")
  println(number + 1)
  println(number + 1)
  println(number + 1)
}

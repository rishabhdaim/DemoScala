package com.journaldev

import scala.io.StdIn

/**
  * Created by rishabh on 24/4/18.
  */
object ConsoleTest {

  def main(args: Array[String]) {
    Console.println("Enter a number :")
    val num = StdIn.readInt()
    Console.println("Entered number is :" + num)
  }

}

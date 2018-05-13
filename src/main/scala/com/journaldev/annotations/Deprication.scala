package com.journaldev.annotations

/**
  * Created by diam on 5/13/2018.
  */
object Deprication extends App {

  @deprecated
  def printMessage = println("This method is depricated")

  printMessage
}

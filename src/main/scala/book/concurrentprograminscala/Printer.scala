package book.concurrentprograminscala

/**
  * Created by diam on 8/1/2018.
  */
class Printer(val greeting: String) {
  def printMessage(): Unit = println(greeting + "!")
  def printNumber(x: Int): Unit = {
    println("Number: " + x)
  }
}

object Printer extends App {
  val printer = new Printer("Daim")
  printer.printMessage()
  printer.printNumber(27)
}

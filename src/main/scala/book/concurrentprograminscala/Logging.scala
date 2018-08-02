package book.concurrentprograminscala

/**
  * Created by diam on 8/1/2018.
  */
trait Logging {
  def log(s: String): Unit
  def warn(s: String) = log("WARN: " + s)
  def error(s: String) = log("ERROR: " + s)
}

class PrintLogging extends Logging {
  def log(s: String) = println(s)
}

object PrintLogging extends App {
  val printLogging = new PrintLogging
  printLogging.warn("This is warning")
  printLogging.error("This is error")
}

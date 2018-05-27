package book.programinscala

/**
  * Created by diam on 5/25/2018.
  */
class RepeatGreeter(greeting: String, count: Int) {

  def this(greeting: String) = this(greeting, 1)

  def greet(): Unit = {
    for (i <- 1 to count) println(greeting)
  }
}

object RepeatGreeter extends App {
  val g1 = new RepeatGreeter("Hello, world", 3)
  g1.greet()
  val g2 = new RepeatGreeter("Hi there!")
  g2.greet()
}

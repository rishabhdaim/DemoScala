package book.programinscala

/**
  * Created by diam on 5/25/2018.
  */
class SimpleGreeter {

  val greeting = "Hello, world!"
  def greet() = println(greeting)

}

object SimpleGreeter extends App {
  val sg = new SimpleGreeter
  sg.greet()
}

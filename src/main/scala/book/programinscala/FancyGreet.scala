package book.programinscala

import java.util.Objects

/**
  * Created by diam on 5/25/2018.
  */
class FancyGreet(greeting: String) {
  Objects.requireNonNull(greeting, () => "Greeting mustn't be null")
  def greet() = println(greeting)
}

object FancyGreet extends App {
  val g = new FancyGreet("Hi!!")
  g.greet()
}

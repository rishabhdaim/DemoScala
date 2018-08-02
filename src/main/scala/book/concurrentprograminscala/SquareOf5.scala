package book.concurrentprograminscala

/**
  * Created by diam on 8/1/2018.
  */
object SquareOf5 extends App {
  def square(x: Int): Int = x * x

  val twice: Int => Int = (x: Int) => x * 2
  val thrice = (x: Int) => x * 3
  val quad: Int => Int = x => x * 4
  val pent: Int => Int = _ * 5

  def runTwice(body: => Unit) = {
    body
    body
  }

  val s = square(5)
  println(s"Result: $s")
  println(s"Result: ${twice(12)}")
  println(s"Result: ${thrice(12)}")
  println(s"Result: ${quad(12)}")
  println(s"Result: ${pent(12)}")
  runTwice{println("2 times")}

  println(for(i <- 0 until 10) yield -i)
  println((0 until 10) map (i => -1 * i))
  println(for (x <- 0 until 4; y <- 0 until 4) yield (x, y))
  println((0 until 4) flatMap(x => 0 until 4))
  println((0 until 4) flatMap(x => (0 until 4) map(y => (x, y))))
}

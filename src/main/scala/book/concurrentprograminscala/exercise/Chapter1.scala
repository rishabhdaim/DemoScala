package book.concurrentprograminscala.exercise

import scala.math._
/**
  * Created by diam on 8/7/2018.
  */
class Chapter1 {

  def compose[A, B, C] (g: B => C, f: A => B): A => C = {
    f.andThen(g)
  }

  def fuse[A, B] (a: Option[A], b: Option[B]): Option[(A, B)] = {
    for {x <- a; y <- b} yield (x, y)
  }

  def check[T](xs: Seq[T])(pred: T => Boolean): Boolean = {
    xs.filter( _ != 0).forall(pred)
  }

  def pairMatching(any: Any) : Unit = {
    any match {
      case Pair(a, b) => println(a, b)
      case _ => println("Some other class")
    }
  }
}

object Chapter1 extends App {

  val chapter1 = new Chapter1

  // compose test
  val f = (x: String) => x.length
  val g = (x: Int) => sqrt(x)
  val h: String => Double = chapter1.compose(g, f)
  println(h.apply("Four"))

  // fuse test
  println(chapter1.fuse(Some("Rishabh"), None))
  println(chapter1.fuse(Some("Rishabh"), Some("Daim")))

  // check test
  println(chapter1.check(0 until 10)(40/ _ > 0))
  println(chapter1.check(0 until 50)(40/ _ > 0))

  // pair matching
  chapter1.pairMatching(Pair("Rishabh", 27))
  chapter1.pairMatching("Rishabh")
}
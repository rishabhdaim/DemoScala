package book.programinscala.traits

/**
  * Created by diam on 6/13/2018.
  */
class Frog extends Printable {
  override def toString = "a frog"
}

object Frog extends App {
  val frog = new Frog
  println(frog)
  frog.print()

  val pr: Printable = frog
  pr.print()
}

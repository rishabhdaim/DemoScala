package book.programinscala

/**
  * Created by diam on 5/31/2018.
  */
object Closures extends App {
  def increaser(more: Int) = (x: Int) => x + more

  println(increaser(5).andThen(x => x * 15)(20))
  println(increaser(20)(12))
}

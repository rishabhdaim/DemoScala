package book.programinscala

/**
  * Created by diam on 5/31/2018.
  */
object CurriedFunction extends App {

  // normal function
  def plainOldSum(x: Int, y: Int) = x + y

  def curriedSum(x: Int)(y: Int) = x + y

  def first(x: Int) = (y: Int) => x + y

  def twice(op: Double => Double, x: Double) = op(op(x))

  println(plainOldSum(2, 4))
  val twoPlus = curriedSum(2)_
  println(twoPlus)
  println(twoPlus(4))
  println(curriedSum(2)(4))
  val second = first(2)
  println(second)
  println(second(4))
  println(twice(_ + 2, 8))
}

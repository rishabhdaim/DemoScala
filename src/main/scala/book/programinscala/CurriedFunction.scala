package book.programinscala

/**
  * Created by diam on 5/31/2018.
  */
object CurriedFunction extends App {

  // normal function
  def plainOldSum(x: Int, y: Int) = x + y

  def curriedSum(x: Int)(y: Int) = x + y

  def first(x: Int) : Int => Int = (y: Int) => x + y

  def twice(op: Double => Double, x: Double) = op(op(x))
  def triple(op: Double => Double, x: Double) = op(op(op(x)))

  val partialSum = curriedSum(5) _

  def complex: Int => Int = partialSum andThen first(10)

  def add(a: Int)(implicit b: Int): Int = a + b

  println(plainOldSum(2, 4))
  val twoPlus = curriedSum(2)_
  println(twoPlus)
  println(twoPlus(4))
  println(curriedSum(2)(4))
  val second = first(2)
  println(second)
  println(second(4))
  println(twice(_ + 4, 8))
  println(triple(_ + 4, 8))
  println(complex(10))
  implicit val v = 10
  println(add(2))
}

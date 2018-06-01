package book.programinscala

/**
  * Created by diam on 5/31/2018.
  */
object Assertions extends App {
  var assertionsEnabled = true
  def myAssert(predicate: () => Boolean) =
    if (assertionsEnabled && !predicate())
      throw new AssertionError
    else
      println("PASSED!")

  def byNameAssert(predicate: => Boolean) =
    if (assertionsEnabled && !predicate)
      throw new AssertionError
    else
      println("PASSED!")


  myAssert(() => 5 > 3)
  byNameAssert(5 > 3)

  assertionsEnabled = false
  byNameAssert(throw new Exception) // will pass since assertions are disabled now
}

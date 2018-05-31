package book.programinscala

/**
  * Created by diam on 5/31/2018.
  */
object PartiallyAppliedFunctions extends App {

  val someNumbers = List(-11, -10, -5, 0, 5, 10)
  var s: Int = _
  // partially applied function
  someNumbers.foreach(println _)
  // same as above, only applicable because compiler knows
  // a function is required at this place
  someNumbers.foreach(println)

  println(someNumbers.filter(x => x > 0))
  println(someNumbers.filter(_ > 0))
  println(someNumbers.drop _)
  println(someNumbers.foreach(s += _))
  println(s)

  private def sum(a: Int, b: Int, c: Int) = a + b + c

  val a = sum _
  println(a(1,2,3))

  val b = sum(1, _: Int, 3)
  println(b(2))
}

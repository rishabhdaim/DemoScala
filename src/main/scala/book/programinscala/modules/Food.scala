package book.programinscala.modules

/**
  * Created by diam on 7/11/2018.
  */
abstract class Food(val name: String) {
  override def toString = name
}
object Apple extends Food("Apple")
object Orange extends Food("Orange")
object Cream extends Food("Cream")
object Sugar extends Food("Sugar")

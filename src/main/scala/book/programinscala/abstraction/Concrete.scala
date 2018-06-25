package book.programinscala.abstraction

/**
  * Created by diam on 6/26/2018.
  */
class Concrete extends Abstract {

  type T = String
  def transform(x: String): String = x + x
  val initial: String = "Hi"
  var current: String = "Daim"
}

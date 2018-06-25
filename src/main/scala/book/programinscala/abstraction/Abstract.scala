package book.programinscala.abstraction

/**
  * Created by diam on 6/26/2018.
  */
trait Abstract {
  type T
  def transform(x: T): T
  val initial: T
  var current: T
}

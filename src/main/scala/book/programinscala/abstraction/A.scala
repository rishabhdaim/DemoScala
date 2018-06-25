package book.programinscala.abstraction

/**
  * Created by diam on 6/26/2018.
  */
abstract class A {
  val v: String // ‘v' for value
  def m: String // ‘m' for method
}

class C1 extends A {
  override val v: String = "Hi" // ‘v' for value
  override val m: String = "Daim" // can override def with a val but not vice versa
}
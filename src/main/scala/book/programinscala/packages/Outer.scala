package book.programinscala.packages

/**
  * Created by diam on 6/16/2018.
  */
class Outer {
  class Inner {
    private def f() {println("f")}
    private[Outer] def g() {println("g")}
    private[this] def h() {println("h")}

    class InnerMost {
      f() // OK to access private method since we are inside Inner class
      g()
      h()
    }
  }
// can't access private member of inner class, can be only accessed from inside Inner class
//  (new Inner).f()
  (new Inner).g()
}

object Outer extends App {
  val outer = new Outer
  val inner = new outer.Inner
  val innerMost = new inner.InnerMost
  inner.g() // can be accessed till Outer
}

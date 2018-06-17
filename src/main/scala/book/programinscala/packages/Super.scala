package book.programinscala.packages

/**
  * Created by diam on 6/16/2018.
  */
class Super {
  protected def f() {println("f")}

  protected[packages] def g() {println("g")}
}

class Sub extends Super {
  f()
}

class Other {
  // can't access protected member from same package, must be sub-class
//  (new Super).f()
  (new Super).g()
}

object Super extends App {
  (new Sub).f()
  new Other
}

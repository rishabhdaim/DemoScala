package com.monads

import cats.data.Validated._
import cats.data._


class BarException extends Exception
class BazException extends Exception
class ComputeException(exception: Exception) extends Exception

class Foo {
  def bar: Option[Bar] = { Some(new Bar) }
  def barEx: Validated[BarException, Bar] = new Valid[Bar](new Bar)
  def barMEx: Validation[BarException, Bar] = new Success[BarException, Bar](new Bar)

}

class Bar {
  def baz: Option[Baz] = { Some(new Baz) }
  def bazEx: Validated[BazException, Baz] = new Valid[Baz](new Baz)
  def bazMEx: Validation[BazException, Baz] = new Success[BazException, Baz](new Baz)
}

class Baz {
  def compute: Int = { 10 }
  def computeEx: Validated[ComputeException, Int] = new Valid[Int] (10)
  def computeMEx: Validation[ComputeException, Int] = new Success[ComputeException, Int] (10)
}

object Foo {
  def computeBaz(baz: Baz): Int = baz.compute
  def computeBar(bar: Bar): Option[Int] = bar.baz.map{ computeBaz }
  def computeFoo(foo: Foo) : Option[Int] = foo.bar.flatMap{ computeBar }
  def compute(foo: Option[Foo]): Option[Int] = foo.flatMap{ computeFoo }

  def computeMonad(fooOpt: Option[Foo]): Option[Int] = {
    for {
      foo <- fooOpt
      bar <- foo.bar
      baz <- bar.baz
    } yield baz.compute
  }

  def computeEx(foo: Foo): Validated[ComputeException, Int] = {
    val barV = foo.barEx.leftMap { new ComputeException(_)}
    val bazV = barV.andThen { bar => bar.bazEx }.leftMap { new ComputeException(_)}
    bazV.andThen { baz => baz.computeEx}
  }

  def computeMEx(foo: Foo): Validation[ComputeException, Int] = {
    for {
      bar <- foo.barMEx.liftFail { new ComputeException(_) }
      baz <- bar.bazMEx.liftFail { new ComputeException(_) }
      result <- baz.computeMEx
    } yield result
  }
}

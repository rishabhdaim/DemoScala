package com.scalatest.mock

import org.scalamock.scalatest.MockFactory
import org.scalatest.FlatSpec

/**
  * Created by diam on 5/23/2018.
  */
class ScalaMock extends FlatSpec with MockFactory {

  val m = mockFunction[Int, String]

  m expects (42) returning "Forty Two" once

  "A Mock function" should "return String Value of passed int" in {
    assert(m.apply(42) === "Forty Two")
  }
}

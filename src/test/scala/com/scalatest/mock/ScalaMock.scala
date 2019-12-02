package com.scalatest.mock

import org.scalamock.function.MockFunction1
import org.scalamock.scalatest.MockFactory
import org.scalatest.flatspec.AnyFlatSpec

import scala.language.postfixOps

/**
  * Created by diam on 5/23/2018.
  */
class ScalaMock extends AnyFlatSpec with MockFactory {

  val m: MockFunction1[Int, String] = mockFunction[Int, String]

  m expects (42) returning "Forty Two" once

  "A Mock function" should "return String Value of passed int" in {
    assert(m.apply(42) === "Forty Two")
  }
}

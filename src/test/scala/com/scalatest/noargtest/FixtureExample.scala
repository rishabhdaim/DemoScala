package com.scalatest.noargtest

import java.io.File

import org.scalatest.{Failed, FlatSpec}

/**
  * Created by diam on 5/23/2018.
  */
class FixtureExample extends FlatSpec {

  override def withFixture(test: NoArgTest) = {

    super.withFixture(test) match {
      case failed: Failed =>
        val currDir = new File(".")
        val fileNames = currDir.list()
        info("Dir snapshot: " + fileNames.mkString(", "))
        failed
      case other => other
    }
  }

  "This test" should "succeed" in {
    assert(1 + 1 === 2)
  }

  it should "fail" in {
    assert(1 + 1 === 3)
  }
}

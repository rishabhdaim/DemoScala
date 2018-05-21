package com.alvinalexander

import org.scalatest.{BeforeAndAfter, FunSpec}

/**
  * Created by diam on 5/22/2018.
  */
class PizzaSpec extends FunSpec with BeforeAndAfter {

  var pizza: Pizza = _

  before {
    pizza = new Pizza
  }

  describe("A Pizza") {

    it("should start with no toppings") {
      assert(pizza.getToppings.size == 0)
    }

    it("should allow addition of toppings") (pending)

    it("should allow removal of toppings") (pending)

    it("should throw an exception") {
      val thrown = intercept[Exception] {
        pizza.boom
      }

      assertResult("Boom!") {
        thrown.getMessage
      }
    }
  }
}

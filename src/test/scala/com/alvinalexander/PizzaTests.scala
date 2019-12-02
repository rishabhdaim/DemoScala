package com.alvinalexander

import org.scalatest.BeforeAndAfter
import org.scalatest.funsuite.AnyFunSuite

/**
  * Created by diam on 5/22/2018.
  */
class PizzaTests extends AnyFunSuite with BeforeAndAfter {

  var pizza: Pizza = _

  before {
    pizza = new Pizza
  }

  test("new pizza has zero toppings") {
    assert(pizza.getToppings.size == 0)
  }

  test("adding one topping") {
    pizza.addTopping(Topping("green olives"))
    assert(pizza.getToppings.size === 1)
  }

  // mark that you want a test here in the future
  test ("test pizza pricing") (pending)

  test ("catching an exception") {
    val thrown = intercept[Exception] {
      pizza.boom
    }
    assert(thrown.getMessage === "Boom!")
  }
}

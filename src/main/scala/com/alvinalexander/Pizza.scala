package com.alvinalexander

import scala.collection.mutable.ArrayBuffer

/**
  * Created by diam on 5/22/2018.
  */
class Pizza {

  private val toppings = new ArrayBuffer[Topping]

  def addTopping (t: Topping) { toppings += t}
  def removeTopping (t: Topping) { toppings -= t}
  def getToppings = toppings.toList

  def boom { throw new Exception("Boom!") }
}

case class Topping(name: String)

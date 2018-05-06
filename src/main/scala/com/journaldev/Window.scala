package com.journaldev

/**
  * Created by diam on 5/7/2018.
  */
class Window {

  private val height = 3.2f
  private val width = 5.6f

  private def winHeight = println(s"Window height is : $height")

  def subtract(a: Float, b: Float) = {
    val s = b - a
    println(s"Difference is : $s")
  }

  def add = {
    val (a, b) = (10, 20)
    val c = a + b
    println(s"Sum is $c")
  }

  println(s"Window width is : $width")
}

object Window extends App {
  var window = new Window

  window.winHeight

  window.subtract(window.height, window.width)
  window.add
}

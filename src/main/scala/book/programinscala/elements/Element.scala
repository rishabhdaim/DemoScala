package book.programinscala.elements

import Element.elem

/**
  * Created by diam on 6/12/2018.
  */
abstract class Element {

  // abstract method, no need to explicit abstract modifier unlike java
  def contents: Array[String]

  def width: Int = {
    if (height == 0) 0 else contents(0).length
  }

  def height: Int = contents.length

  def above(that: Element): Element = {
    val this1 = this widen that.width
    val that1 = that widen this.width
    new ArrayElement(this1.contents ++ that1.contents)
  }

  def beside(that: Element): Element = {
    val this1 = this heighten that.height
    val that1 = that heighten this.height
//    val contents = new Array[String](this1.contents.length)
//    for (i <- 0 until this1.contents.length)
//      contents(i) = this1.contents(i) + that1.contents(i)
//    new ArrayElement(contents)
    // writing above in functional way
    new ArrayElement(
      for ((line1, line2) <- this1.contents zip that1.contents)
        yield line1 + line2
    )
  }

  def inverse(x: Double): Double = {
    assume(x != 0, "must be non-zero"); 1 / x
  }

  override def toString = contents mkString "\n"

  // private helper methods

  private def widen(w: Int): Element =
    if (w <= width) this
    else {
      val left = elem(' ', (w - width)/ 2, height)
      val right = elem(' ', w - width - left.width, height)
      left beside this beside right
    }

  def heighten(h: Int): Element =
    if (h <= height) this
    else {
      val top = elem(' ', width, (h - height) / 2)
      val bot = elem(' ', width, h - height - top.height)
      top above this above bot
    }
}

object Element {
  def elem(contents: Array[String]): Element = new ArrayElement(contents)
  def elem(chr: Char, width: Int, height: Int): Element = new UniformElement(chr, width, height)
  def elem(line: String): Element = new LineElement(line)
}

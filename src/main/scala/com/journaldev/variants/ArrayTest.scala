package com.journaldev.variants

/**
  * Created by diam on 5/13/2018.
  */
object ArrayTest extends App {

  var a: ArrayTest[Any]  = new ArrayTest[Any]().add("US")
  a = a.add(12)
  a = a.add(12.12)

  println("Array elements added are: " + a)
}

class ArrayTest[+X] {

  def add[Y >: X](elem: Y): ArrayTest[Y] = new ArrayTest[Y] {
    override def first: Y = elem
    override def retrieve: ArrayTest[Y] = ArrayTest.this
    override def toString() = elem.toString() + "\n" + ArrayTest.this.toString()
  }
  def first: X = sys.error("No elements in the Array")
  def retrieve: ArrayTest[X] = sys.error("Array is empty")
  override def toString() = ""
}

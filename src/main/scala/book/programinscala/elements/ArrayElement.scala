package book.programinscala.elements

/**
  * Created by diam on 6/12/2018.
  */

// we can override method in single constructor class inside the class's primary constructor
private class ArrayElement(val contents: Array[String]) extends Element {

  // abstract method, no need to explicit abstract modifier unlike java
  // we can override parameter less method with fields
  //  override val contents: Array[String] = conts
}

package com.journaldev

/**
  * Created by diam on 5/9/2018.
  */
object Sets extends App {

  val country: Set[String] = Set("Russia", "Denmark", "Sweden")
  println(country)

  var id : Set[Int] = Set(4,5,6,7,8,9)
  println(id)

  // empty set
  var age: Set[Nothing] = Set()
  println(age)

  val name = Set("Smith", "Brown", "Allen")
  println( "Head of name : " + name.head )
  println( "Tail of name : " + name.tail )
  println( "Check if name is empty : " + name.isEmpty)
  println( "Check if id is empty : " + age.isEmpty)

  // concat 2 sets by '++'
  val furniture_1 = Set("Sofa", "Table", "chair")
  val furniture_2 = Set("Bed", "Door")

  var furniture = furniture_1 ++ furniture_2
  println( "furniture_1 ++ furniture_2 : " + furniture)

  var furn = furniture_1.++(furniture_2)
  println( "furniture_1.++(furniture_2) : " + furn)

  // set intersection '&' OR 'intersection'
  val n1 = Set(11,45,67,78,89,86,90)
  val n2 = Set(10,20,45,67,34,78,98,89)

  println( "n1.&(n2) : " + n1.&(n2))
  println( "n1.intersect(n2) : " + n1.intersect(n2))

  // min & max
  println( "Minimum  element in the Set is : " + n1.min)
  println( "Maximum  element in the Set is : " + n2.max)

  // contains
  println(s"Set contains 45 : ${n1.contains(45)}")
  println(s"Set contains 55 : ${n1.contains(55)}")
  println(s"Last element is : ${n1.last}")
  println(s"Product is : ${n1.product}")
  println(s"Sum is : ${n1.sum}")
  println(s"Size is : ${n1.size}")
  println(s"List is : ${n1.toList}")
  println(s"Seq is : ${n1.toSeq}")
  println(s"Array is : ${n1.toArray}")
}

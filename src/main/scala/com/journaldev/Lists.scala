package com.journaldev

/**
  * Created by diam on 5/9/2018.
  */
object Lists extends App {

  var studentNames: List[String] = List("Rohan", "Andreas", "Rob", "John")
  println(studentNames)
  // empty list
  val em: List[Nothing] = List()
  println(em)

  // 2-D list
  val twoDim: List[List[Int]] = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1))
  println(twoDim)

  // "::" appends the element to the head of list
  val names = "Harry" :: ("Adam" :: ("Jill" :: Nil))
  val age = Nil
  println("Head of names array : " + names.head)
  println("Tail of names array : " + names.tail)
  println("Check if names is empty : " + names.isEmpty)
  println("Check if age is empty : " + age.isEmpty)

  // list concatenation, 3 ways ':::', '.:::' OR 'concat'
  val country_1 =  List("India","SriLanka","Algeria")
  val country_2 = List("Austria","Belgium","Canada")
  val country = country_1 ::: country_2
  println("country_1 ::: country_2 : " + country)

  val cont = country_1.:::(country_2)
  println("country_1.:::(country_2) : " + cont)
  val con = List.concat(country_1, country_2)
  println("List.concat(country_1, country_2) : " + con)

  // reverse list
  println("Country List before reversal :" + country)
  println("Country List after reversal :" + country.reverse)
  println("Country List after sorting :" + country.sorted)

  // fill list with same element
  val name = List.fill(6)("Daim")
  println("Name : " + name  )

  val id = List.fill(6)(12)
  println("Id : " + id)
  println(s"Length is : ${id.length}")
  println(s"Sum is : ${id.sum}")

  // distinct method
  val distinctId = id.distinct
  println(s"Distinct Ids : $distinctId")

  // toMap function
  val mapList = id zip name
  println(s"Map is : ${mapList.toMap}")
}

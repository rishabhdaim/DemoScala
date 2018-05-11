package com.journaldev

/**
  * Created by rishabh on 11/5/18.
  */
object Iterators extends App {

  val car = Iterator("Santro", "Punto", "WagonR", "Polo", "Audi")

  while (car.hasNext) {
    println(car.next())
  }

  println("Iterator car : " + car.size)
  println("Length of car : " + car.length)

  val m1 = Iterator(12,45,67,89)
  val m2 = Iterator(44,66,77,88)

  println("Smallest element " + m1.min )
  println("Largest element " + m2.max )
}

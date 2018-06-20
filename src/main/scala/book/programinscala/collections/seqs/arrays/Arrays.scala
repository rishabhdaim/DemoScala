package book.programinscala.collections.seqs.arrays

/**
  * Created by diam on 6/20/2018.
  */
class Arrays {

  val numbers = new Array[Int](5)
  val words = "The quick brown fox".split(" ")
}

object Arrays extends App {
  val array = new Arrays
  println("basic operations : ")
  println(array.numbers(2))

  array.numbers(2) = 2 // calls update method
  println(array.numbers(2))

  println("Looping : ")
  for(x <- array.numbers) println(x)
  for(x <- array.numbers.indices) println(x + " => " + array.numbers(x))
  for(x <- 0 until array.words.length) println(x + " => " + array.words(x))
}

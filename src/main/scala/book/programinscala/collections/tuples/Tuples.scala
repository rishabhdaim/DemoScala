package book.programinscala.collections.tuples

/**
  * Created by diam on 6/20/2018.
  */
class Tuples {

  def longestWords(words: Array[String]) : (String, Int) = {
    var word = words(0)
    var idx = 0

    for (i <- 1 until words.length if words(i).length > word.length){
      word = words(i)
      idx = i
    }
    (word, idx)
  }
}

object Tuples extends App {
  val tuple = new Tuples

  println(tuple.longestWords("The quick brown fox".split(" ")))
}

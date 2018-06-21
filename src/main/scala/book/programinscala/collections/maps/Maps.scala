package book.programinscala.collections.maps

import scala.collection.mutable

/**
  * Created by diam on 6/21/2018.
  */
class Maps {
  val map = mutable.Map.empty[String, Int]

  map("hello") = 1
  map("there") = 2

  def wordCounts(text: String) : mutable.Map[String, Int] = {
    val counts = mutable.Map.empty[String, Int]
    for (w <- text.split("[ ,!]+")) {
      val word = w.toLowerCase
      val oldCount = if (counts.contains(word)) counts(word) else 0
      counts(word) = oldCount + 1
    }
    counts
  }
}

object Maps extends App {
  val maps = new Maps

  println(maps.map)
  println(maps.wordCounts("See Spot run! Run, Spot, run!!"))
}

package book.programinscala.collections.sets

import scala.collection.mutable

/**
  * Created by diam on 6/21/2018.
  */
class Sets {
  val words = mutable.Set.empty[String]

  val text = "See Spot run. Run, Spot, Run!"
}

object Sets extends App {
  val sets = new Sets

  println("Sets operation : ")
  sets.words.+=("hello")
  sets.words += "there"
  sets.words += "there"

  println(sets.words)

  for (w <- sets.text.split("[ !,.]+")) println(w)
  for (w <- sets.text.split("[ !,.]+")) sets.words += w.toLowerCase
  println(sets.words)
}

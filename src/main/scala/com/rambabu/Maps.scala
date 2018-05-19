package com.rambabu

/**
  * Created by diam on 5/19/2018.
  */
object Maps extends App {

  val emptyMap: Map[String, String] = Map()
  println(emptyMap)
  println(emptyMap.getClass)

  var map1 = Map(1 -> "one", 2 -> "two")
  println(map1)

  // add new value
  map1 = map1 + (3 -> "three")
  println(map1)

  map1 = map1 + Tuple2(4, "four")
  println(map1)

  val map2 = Map(5 -> "five", 6 -> "six")
  println(map2)

  // concatenate maps
  val fullMap = map1 ++ map2
  println(fullMap)

  println(fullMap.mapValues(v => v.toUpperCase))
}

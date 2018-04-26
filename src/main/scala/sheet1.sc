/**
 * Created by diam on 2/23/2018.
 */
import scala.collection.mutable.ArrayBuffer
import scala.math._

object Sheet1 {
  println("Welcome to scala")
  var answer: Int = 8*5 + 2
  answer * 0.5
  answer = (answer * 1.55).toInt
  val v = ("Hello, " + answer).toLowerCase
  v.toUpperCase
  answer.toString
  answer.to(32)
  "Hello".intersect("World")
  1 to 20
  answer+=1
  val x: BigInt = 1234567890
  x*x*x
  "rishabh".sorted
  sqrt(4)
  pow(i.toLong, 3)
  min(3, Pi)
  BigInt.probablePrime(100, scala.util.Random)
  v(4)
  var i = 10
  var r = 1
  val s = if (i > 1) {
    1
  } else if (i == 10){
    0
  } else {
    -1
  }
  if (i > 1) {
    r = r*i; i-=1;
  }
  println(r)
  val nums = new Array[Int](10)
  val strArr = Array("Hello", "World")
  println(strArr(0))
  println(strArr(1))
  strArr(0) = "GoodBye"
  println(strArr(0))
  val ar = ArrayBuffer[Int]()
  ar += 1
  ar += (1,2,3,4)
  ar ++= Array(11,12,13)
  for (i <- 0 until ar.length) print(s"$i:${ar(i)} ,")
  for(i <- ar.indices.reverse) print(s"$i:${ar(i)} ,")
  for(elem <- ar) print(elem + " ,")
  var re = for(elem <- ar) yield 2 * elem
  re = for(elem <- ar if elem % 2 == 0) yield 2 * elem
  re = ar filter{_ % 3 == 0} map {2 * _}
  re = ar.filter(_ % 4 == 0).map(2*_)
  val sum = ar.sum
  re = ar.sorted
  re = ar.sortWith(_ > _)
  var a = Array("Mary", "a", "had", "lamb", "little")
  java.util.Arrays.binarySearch(a.asInstanceOf[Array[Object]], "beaf")


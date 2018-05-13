package com.journaldev.polymorphic

/**
  * Created by diam on 5/13/2018.
  */
object PolymorphicMethod extends App {

  def getList[T] (x:T, y:Int) : List[T] = {
    if (y == 0) Nil
    else x :: getList(x, y -1)
  }

  println(getList[Int](3, 3))
  println(getList[String]("Hi! ", 3))
}

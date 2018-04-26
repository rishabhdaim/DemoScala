package com.marklewis

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by diam on 4/25/2018.
  */
object DeadLockTest extends App {
  var b1 = collection.mutable.Buffer[String]()
  var b2 = collection.mutable.Buffer[String]()

  def doWork(count: Int): Unit = Thread.sleep(count)

  def useBuffers(buf1: collection.mutable.Buffer[String], buf2: collection.mutable.Buffer[String]) : Unit = {
    buf1.synchronized {
      doWork(1000)
      buf2.synchronized{
        doWork(1000)
      }
    }
  }

  Future(useBuffers(b1, b2)).foreach{_ => println("Call 1 is done")}
  Future(useBuffers(b2, b1)).foreach{_ => println("Call 2 is done")}

  Thread.sleep(3000)
  println("Main done")
}

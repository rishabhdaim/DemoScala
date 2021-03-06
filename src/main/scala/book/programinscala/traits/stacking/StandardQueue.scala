package book.programinscala.traits.stacking

import scala.collection.mutable.ArrayBuffer

/**
  * Created by diam on 6/14/2018.
  */
class StandardQueue extends Queue {
  private val buf = new ArrayBuffer[Int]
  def get = {
    println("Getting value Standard queue")
    buf.remove(0)
  }
  def put(x: Int) = {
    println("Putting value Standard queue")
    buf += x
  }
}

object StandardQueue extends App {
  val q1 = new StandardQueue with LockingQueue with LoggingQueue
  val q2 = new StandardQueue with LoggingQueue with LockingQueue

  q1.put(2)
  println("-------------------------")
  q2.put(4)
}

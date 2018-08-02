package book

/**
  * Created by diam on 8/1/2018.
  */
package object concurrentprograminscala {
  def log(msg: String): Unit = println(s"${Thread.currentThread.getName}: $msg")
}

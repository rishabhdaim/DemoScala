package com.marklewis

import scala.collection.immutable.IndexedSeq
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}
import scala.util.{Failure, Success}
/**
  * Created by diam on 4/25/2018.
  */
object FutureTest extends App {

  println("First Line")
  val f:Future[Unit] = Future {
    println("Printing in the Future")
  }
  Thread.sleep(1)
  println("Last Line")

  val f2: Future[IndexedSeq[Int]] = Future {
    for (i <- 1 to 30) yield ParallelCollect fib i
    // throw new RuntimeException("Done throwing exception")
  }

  println(Await.result(f2, 5 seconds))

  f2.foreach(println)

  f2.onComplete {
    case Success(n) => println(n)
    case Failure(ex) => println("Something wrong. " + ex.getMessage)
  }

  val page1 = Future {
    "Google " + io.Source.fromURL("http://www.google.com").take(200).mkString
  }

  val page2 = Future {
    "Yahoo " + io.Source.fromURL("http://www.yahoo.com").take(200).mkString
  }

  val page3 = Future {
    "Bing " + io.Source.fromURL("http://www.bing.com").take(200).mkString
  }

  val pages = List(page1, page2, page3)
  val firstPage = Future.firstCompletedOf(pages)
  firstPage.foreach(println)

  val allPages = Future.sequence(pages)
  allPages.foreach(println)

  Thread.sleep(10000)
}

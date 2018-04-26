package com.marklewis.actor

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

/**
  * Created by diam on 4/27/2018.
  */
object ActorCountDown extends App {

  case class StartCounting(n:Int, other:ActorRef)
  case class CountDown(n:Int)

  class CountDownActor extends Actor {
    override def receive: Receive = {
      case StartCounting(n, other) => {
        println("Integer Value : " + n)
        other ! CountDown(n -1)
      }
      case CountDown(n) => {
        println(self)
        if (n > 0) {
          println(n)
          sender ! CountDown(n -1)
        } else {
          context.system.terminate
        }
      }
    }

    def foo(s: String) : Unit = println("Normal method : " + s)
  }

  val system = ActorSystem("SimpleActorSystem")
  val countDownActor1 = system actorOf(Props[CountDownActor], "CountDownActor1")
  val countDownActor2 = system actorOf(Props[CountDownActor], "CountDownActor2")

  countDownActor1 ! StartCounting(10, countDownActor2)
}

package com.marklewis.actor

import akka.actor.{Actor, ActorSystem, Props}
import akka.actor.Actor.Receive

/**
  * Created by diam on 4/26/2018.
  */
object SimpleActorExample extends App {

  class SimpleActor extends Actor {
    override def receive: Receive = {
      case s:String => println("String : " + s)
      case i:Int => println("Integer : " + i)
    }

    def foo(s: String) : Unit = println("Normal method : " + s)
  }

  val system = ActorSystem("SimpleActorSystem")
  val simpleActor = system actorOf(Props[SimpleActor], "SimpleActor")

  println("Before Sending Messages")
  simpleActor ! "Hi!! Daim"
  println("Before Sending Int")
  simpleActor ! 27
  println("After Sending Messages")
  simpleActor ! 'r'
  println("After Sending Character")

  system.terminate()
}

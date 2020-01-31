package com.marklewis.actor.router

import akka.actor.{Actor, ActorSystem, Props}
import akka.event.LoggingReceive
import akka.routing.FromConfig


case class GreetRandom(s: String)

object RouterActorTest  extends App {

  val system = ActorSystem("Router-random")

  val routerPool = system.actorOf(FromConfig.props(Props[RouterActor]), "random-router-pool")

  routerPool ! GreetRandom("Daim")
  routerPool ! GreetRandom("Daim")
  routerPool ! GreetRandom("Daim")
  routerPool ! GreetRandom("Daim")

  Thread.sleep(1000)

  system.terminate()
}

class RouterActor extends Actor {
  override def receive: Receive = LoggingReceive {
    case s@GreetRandom(_) => println(s"Hello ${s.s} from $self")
  }
}

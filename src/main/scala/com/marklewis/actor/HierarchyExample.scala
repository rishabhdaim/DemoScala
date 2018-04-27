package com.marklewis.actor

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

/**
  * Created by diam on 4/27/2018.
  */
object HierarchyExample extends App {

  case object CreateChild
  case class SignalChildren(order:Int)
  case class PrintSignal(order:Int)

  class ParentActor extends Actor {
    private var number = 0
    override def receive: Receive = {
      case CreateChild =>
        context.actorOf(Props[ChildActor], "Child" + number)
        number += 1
      case SignalChildren(n) =>
        context.children.foreach(_ ! PrintSignal(n))
    }
  }

  class ChildActor extends Actor {
    override def receive: Receive = {
      case PrintSignal(n) => println(n + " " + self)
    }
  }

  val system = ActorSystem("HierarchySystem")
  val parentActor = system actorOf(Props[ParentActor], "ParentActor")
  val parentActor2 = system actorOf(Props[ParentActor], "ParentActor2")

  parentActor ! CreateChild
  parentActor ! SignalChildren(1)
  parentActor ! CreateChild
  parentActor ! CreateChild
  parentActor ! SignalChildren(2)

  parentActor2 ! CreateChild
  val child0 = system.actorSelection("/user/ParentActor2/Child0")
  child0 ! PrintSignal(3)

  Thread.sleep(1000)
  system.terminate
}

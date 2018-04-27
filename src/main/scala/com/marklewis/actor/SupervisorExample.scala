package com.marklewis.actor

import akka.actor.SupervisorStrategy.{Restart, Resume}
import akka.actor.{Actor, ActorSystem, OneForOneStrategy, Props}
import akka.io.Tcp.Message
import com.marklewis.actor.HierarchyExample.{PrintSignal, SignalChildren}

/**
  * Created by diam on 4/27/2018.
  */
object SupervisorExample extends App {

  case object CreateChild
  case class SignalChildren(order:Int)
  case class PrintSignal(order:Int)
  case class DivideNumbers(n:Int, d:Int)
  case object BadStuff

  class ParentActor extends Actor {
    private var number = 0
    override def receive: Receive = {
      case CreateChild =>
        context.actorOf(Props[ChildActor], "Child" + number)
        number += 1
      case SignalChildren(n) =>
        context.children.foreach(_ ! PrintSignal(n))
    }

    override val supervisorStrategy = OneForOneStrategy(loggingEnabled = true) {
      case ae:ArithmeticException => Resume
      case _:Exception => Restart
    }
  }

  class ChildActor extends Actor {
    println("Child Created.")
    override def receive: Receive = {
      case PrintSignal(n) => println(n + " " + self)
      case DivideNumbers(n, d) => println(n/d)
      case BadStuff => throw new RuntimeException("Bad Stuff happened")
    }

    override def preStart = {
      super.preStart
      println("PreStart")
    }

    override def postStop = {
      super.postStop
      println("PostStop")
    }

    override def preRestart(reason: Throwable, message: Option[Any]) = {
      super.preRestart(reason, message)
      println("PreRestart")
    }

    override def postRestart(reason: Throwable) = {
      super.postRestart(reason)
      println("PostRestart")
    }
  }

  val system = ActorSystem("HierarchySystem")
  val parentActor = system actorOf(Props[ParentActor], "ParentActor")
  val parentActor2 = system actorOf(Props[ParentActor], "ParentActor2")

  parentActor ! CreateChild
//  parentActor ! CreateChild
  val child0 = system.actorSelection("/user/ParentActor/Child0")
  child0 ! DivideNumbers(4, 0)
  child0 ! DivideNumbers(4, 2)
  child0 ! BadStuff

  Thread.sleep(1000)
  system.terminate
}

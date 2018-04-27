package com.marklewis.actor

import akka.actor.{Actor, ActorSystem, Props}
import scala.concurrent.duration._
/**
  * Created by diam on 4/27/2018.
  */
object SchedulerExample extends App {

  case object Count

  class SchedulerActor extends Actor {
    var n = 0
    override def receive: Receive = {
      case Count =>
        n += 1
        println(n)
    }

    def foo(s: String) : Unit = println("Normal method : " + s)
  }

  val system = ActorSystem("SchedulerActorSystem")
  val schedulerActor = system actorOf(Props[SchedulerActor], "SchedulerActor")
  implicit val ec = system.dispatcher

  schedulerActor ! Count
  system.scheduler.scheduleOnce(1.seconds)(schedulerActor ! Count)
  val can = system.scheduler.schedule(0.seconds, 100.millis, schedulerActor, Count)
  Thread.sleep(2000)
  can.cancel
  system.terminate
}

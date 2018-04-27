package com.marklewis.actor

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import akka.pattern._
import akka.util.Timeout

import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

/**
  * Created by diam on 4/27/2018.
  */
object AskPatternActor extends App {

  case object AskName
  case class AskNameOf(other:ActorRef)
  case class NameResponse(name:String)

  class AskActor(val name:String) extends Actor {
    override def receive: Receive = {
      case AskName => sender ! NameResponse(name)
      case AskNameOf(other) =>
        implicit val timeout = Timeout(1.seconds)
        val f = other ? AskName
        f.onComplete {
          case Success(nr:NameResponse) =>
            println("They said their name was " + nr)
          case Success(s) =>
            println("They didn't tell us their name")
          case Failure(ex) =>
            println("Asking their name failed")
        }
        val currentSender = sender
        Future {
          currentSender ! "message"
        }
    }

    def foo(s: String) : Unit = println("Normal method : " + s)
  }

  val system = ActorSystem("SimpleActorSystem")
  val askActor = system actorOf(Props(new AskActor("Rishu Daim")), "AskActor")
  val askActor2 = system actorOf(Props(new AskActor("Anku Daim")), "AskActor2")

  implicit val timeout = Timeout(1.seconds)
  val answer = askActor ? AskName
  answer.foreach(n => println("Name is : " + n))

  askActor ! AskNameOf(askActor2)
  system.terminate
}

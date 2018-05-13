package com.journaldev.polymorphic

/**
  * Created by diam on 5/13/2018.
  */
object TestTrain extends App {

  println("Linking Compartments.....")
  val t: Train = new ConcreteMetroTrain
  val c1 = t.addCompartment
  val c2 = t.addCompartment
  val c3 = t.addCompartment
  c1.join(c2)
  c2.join(c3)
}

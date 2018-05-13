package com.journaldev.polymorphic

/**
  * Created by diam on 5/13/2018.
  */
class ConcreteMetroTrain extends MetroTrain {
  type Link = LinkImpl
  type Compartment = CompartmentImpl
  protected def newCompartment: Compartment = new CompartmentImpl
  protected def newLink(c1: Compartment, c2: Compartment): Link = new LinkImpl(c1, c2)
}

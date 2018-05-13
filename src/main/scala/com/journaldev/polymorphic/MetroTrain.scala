package com.journaldev.polymorphic

/**
  * Created by diam on 5/13/2018.
  */
abstract class MetroTrain extends Train {
  
  type Link <: LinkImpl

  class LinkImpl(comptA : Compartment, comptB: Compartment) {
    def c1 = comptA
    def c2 = comptB
  }

  class CompartmentImpl extends CompartmentIntf {
    self: Compartment =>
    override def join(compartment: Compartment): Link = {
      val link = newLink(this, compartment)
      links = link :: links
      link
    }
  }

  protected def newCompartment: Compartment
  protected def newLink(c1: Compartment, c2: Compartment): Link

  def addCompartment: Compartment = {
    val compartment = newCompartment
    compartments = compartment :: compartments
    compartment
  }

  var links: List[Link] = Nil
  var compartments: List[Compartment] = Nil
}

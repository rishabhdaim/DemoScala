package com.journaldev.polymorphic

/**
  * Created by diam on 5/13/2018.
  */
abstract class Train {
  type Link
  type Compartment <: CompartmentIntf
  abstract class CompartmentIntf {
    def join(compartment: Compartment): Link
  }

  def compartments: List[Compartment]
  def links: List[Link]
  def addCompartment: Compartment
}

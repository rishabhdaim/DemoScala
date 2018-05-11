package com.journaldev.traits

import scala.io.Source

/**
  * Created by rishabh on 11/5/18.
  */
trait DetCar {

  def readDetails(d:String):String = Source.fromString(d).mkString
}

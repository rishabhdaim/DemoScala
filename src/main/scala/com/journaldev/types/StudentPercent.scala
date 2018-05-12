package com.journaldev.types

/**
  * Created by diam on 5/13/2018.
  */
trait StudentPercent {

  val obtained: Int
  val total: Int
  require(total != 0)
  val perc = (obtained.toFloat / total.toFloat) * 100
  override def toString = "Percentage secured is " + perc
}

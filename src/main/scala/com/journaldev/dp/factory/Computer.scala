package com.journaldev.dp.factory

/**
  * Created by diam on 5/14/2018.
  */
trait Computer {

  def getRAM: String
  def getHDD: String
  def getCPU: String

  override def toString = s"Computer(getRAM=$getRAM, getHDD=$getHDD, getCPU=$getCPU)"
}







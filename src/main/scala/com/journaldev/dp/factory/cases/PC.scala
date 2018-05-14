package com.journaldev.dp.factory.cases

import com.journaldev.dp.factory.Computer

/**
  * Created by diam on 5/14/2018.
  */
case class PC(ram:String, hdd:String, cpu:String) extends Computer {
  override def getRAM: String = ram

  override def getCPU: String = cpu

  override def getHDD: String = hdd
}

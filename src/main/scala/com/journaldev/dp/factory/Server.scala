package com.journaldev.dp.factory

/**
  * Created by diam on 5/14/2018.
  */
private class Server(val ram:String, val hdd:String, val cpu:String) extends Computer{
  def getRAM():String =  ram
  def getHDD():String = hdd
  def getCPU():String = cpu
}

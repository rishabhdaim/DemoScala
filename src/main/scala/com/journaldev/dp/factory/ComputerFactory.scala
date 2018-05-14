package com.journaldev.dp.factory

/**
  * Created by diam on 5/14/2018.
  */
object ComputerFactory {
  def apply(compType:String, ram:String, hdd:String, cpu:String): Computer = {
    compType.toUpperCase match {
      case "PC" => new PC(ram,hdd,cpu)
      case "SERVER" => new Server(ram,hdd,cpu)
    }
  }
}

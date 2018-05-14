package com.journaldev.dp.factory.cases

import com.journaldev.dp.factory.Computer

/**
  * Created by diam on 5/14/2018.
  */
object CaseComputerFactory {
  def apply(compType:String, ram:String, hdd:String, cpu:String): Computer = {
    compType.toUpperCase match {
      case "PC" => PC(ram,hdd,cpu)
      case "SERVER" => Server(ram,hdd,cpu)
    }
  }
}

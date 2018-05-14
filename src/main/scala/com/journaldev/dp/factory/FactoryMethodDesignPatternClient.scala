package com.journaldev.dp.factory

import com.journaldev.dp.factory.cases.CaseComputerFactory

/**
  * Created by diam on 5/14/2018.
  */
object FactoryMethodDesignPatternClient extends App {

  var pc = ComputerFactory("pc","2 GB","500 GB","2.4 GHz");
  var server = ComputerFactory("server","16 GB","1 TB","2.9 GHz");

  println("Factory PC Config:: "+pc);
  println("Factory Server Config:: "+server);

  // with case classes
  pc = CaseComputerFactory("pc","2 GB","500 GB","2.4 GHz");
  server = CaseComputerFactory("server","16 GB","1 TB","2.9 GHz");

  println("Factory PC Config:: "+pc);
  println("Factory Server Config:: "+server);
}

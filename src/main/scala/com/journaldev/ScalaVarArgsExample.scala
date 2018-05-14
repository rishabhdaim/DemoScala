package com.journaldev

import scala.annotation.varargs

/**
  * Created by diam on 5/14/2018.
  */
object ScalaVarArgsExample extends App {

  @varargs
  def display(name:String, str: String*): Unit = {
    println("Non-Varargs : " + name)
    print("Varagrs : ")
    str.map(s => print(s + " "))
  }

  display("Rishu", "Anku", "Munna", "Aru", "Deep")
}

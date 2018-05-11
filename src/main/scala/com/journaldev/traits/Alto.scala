package com.journaldev.traits

/**
  * Created by rishabh on 11/5/18.
  */
class Alto(cname:String, cno:Int, var color:String) extends Car(cname, cno) with DetCar {

  override def details = {
    val det = readDetails(color)
    cname+"\n"+cno+"\n"+"Color:"+det
  }
}

object Alto extends App {
  val alto = new Alto("Alto", 34, "White")
  println(alto.details)
}

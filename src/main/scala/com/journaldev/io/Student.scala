package com.journaldev.io

/**
  * Created by diam on 5/13/2018.
  */
abstract class Student {

  val name:String
  val id:Int
  val marks:Int

  override def toString = name

  def toXml = <student>
    <name>{name}</name>
    <id>{id}</id>
    <marks>{marks}</marks>
  </student>

  def fromXml(node: scala.xml.Node): Student = {
    new Student {override val marks: Int = (node \"marks").text.toInt
      override val name: String = (node \"name").text
      override val id: Int = (node \"id").text.toInt
    }
  }
}

package com.journaldev.io

import scala.xml.Elem

/**
  * Created by diam on 5/13/2018.
  */
object XmlHandling extends App {

  val s = <a>{"Hi"+", Daim"}</a>
  println(s)
  println(s.text)

  val marks = 78
  println(<a> { if ( marks < 80) <marks> {marks} </marks> else xml.NodeSeq.Empty } </a>)
  println(<a> {"</a>Hello Scala<a>"} </a>)

  val stud = new Student {override val marks: Int = 94
    override val name: String = "Anku"
    override val id: Int = 12
  }

  private val studXml: Elem = stud.toXml
  println(studXml)
  println(studXml \\"marks")
  println(studXml \\"name")

  // extract xml attributes

  val rishu = <student name ="rishu" age="27" marks="6.28"/>
  println(rishu \\"@name")
  println(rishu \\"@age")
  println(rishu \\"@marks")

  val student: Student = stud.fromXml(studXml)
  println(student)
}

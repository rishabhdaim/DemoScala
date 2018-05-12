package com.journaldev

/**
  * Created by diam on 5/12/2018.
  */

case class StudentData(name: String, address: Seq[Address])
case class Address(city: String, state: String)

object City {
  def unapply(s: StudentData): Option[Seq[String]] =
    Some(for (c <- s.address) yield c.state)
}

class StringSeqContains(value: String) {
  def unapply(in: Seq[String]): Boolean = in contains value
}

object ApplyPatternMatch extends App {

  val stud = List(StudentData("Harris", List(Address("LosAngeles", "California"))),
    StudentData("Reena", List(Address("Houston", "Texas"))),
    StudentData("Rob", List(Address("Dallas", "Texas"))),
    StudentData("Chris", List(Address("Jacksonville", "Florida"))))

  val Texas = new StringSeqContains("Texas")
  val students = stud collect {
    case student @ City(Texas()) => student.name
  }
  println(students)

}

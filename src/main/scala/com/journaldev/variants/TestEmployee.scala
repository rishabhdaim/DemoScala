package com.journaldev.variants

/**
  * Created by diam on 5/13/2018.
  */
object TestEmployee extends App {

  def findEId[A <: Employee](d: A, ls: List[A]): Boolean = {
    if (ls.isEmpty) false
    else if (d.EmployeeIdExists(ls.head)) true
    else findEId[A](d, ls.tail)
  }
  val eList: List[EId] = List(EId(25), EId(26), EId(27), EId(28))
  if ((findEId[EId](EId(28), eList)))
    println("Employee Id exists")
  else println("Employee Id does not exist")
  if ((findEId[EId](EId(30), eList)))
    println("Employee Id exists")
  else println("Employee Id does not exist")
}


case class EId(a: Int) extends Employee {
  def EmployeeIdExists(x: Any): Boolean = x.isInstanceOf[EId] && x.asInstanceOf[EId].a == a
}
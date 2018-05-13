package com.journaldev.variants

/**
  * Created by diam on 5/13/2018.
  */
case class ListNode[+T] (h: T, t:ListNode[T]) {
  def head: T = h
  def tail: ListNode[T] = t
  def prepend[U >: T](elem: U) : ListNode[U] = ListNode(elem, this)
}

object LowerBoundTest extends App {

  val empty: ListNode[Null] = ListNode(null, null)
  val strList: ListNode[String] = empty.prepend("hello").prepend("world")
  var anyList: ListNode[Any] = strList.prepend(12345)
  anyList = anyList.prepend(12.12)
  println(strList)
  println(anyList)
}

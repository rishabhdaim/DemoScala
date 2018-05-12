package com.journaldev.types

/**
  * Created by diam on 5/13/2018.
  */
trait Student {

  type X
  def totalMarks(m1:X, m2:X): X
  val age: X

  val name:String

  var marks:Int
}

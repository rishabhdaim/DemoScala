package com.marklewis

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by diam on 4/25/2018.
  */
class BankAccount (private var _balance:Int) {
  def balance = _balance

  def deposit(amount: Int) : Boolean = this.synchronized {
    if (amount < 0) false
    else {
      _balance += amount
      true
    }
  }

  def withdraw(amount: Int) : Boolean = this.synchronized {
    if (amount < 0 || amount > _balance) false
    else {
      _balance -= amount
      true
    }
  }
}

object BankAccount extends App {
  val acc = new BankAccount(0)
  // slower with par since we have too much thread contention
  for (i <- (1 to 1000000).par) acc.deposit(1)

  println(acc.balance)

  var cnt:Int = 0
  Future(for (i <- 1 to 1000000) cnt +=1).foreach{_ => println("f1 is done")}
  Future(for (i <- 1 to 1000000) cnt +=1).foreach{_ => println("f2 is done")}

  Thread.sleep(5000)
  println(cnt)
}

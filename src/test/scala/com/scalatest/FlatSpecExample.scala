package com.scalatest

import org.scalatest.flatspec.AnyFlatSpec

import scala.collection.mutable.Stack

/**
  * Created by diam on 5/22/2018.
  */
class FlatSpecExample extends AnyFlatSpec {

  "A Stack" should "pop values in last-in-first-out order" in {
    val stack = new Stack[Int]
    stack.push(1)
    stack.push(2)
    assert(stack.pop() === 2)
    assert(stack.pop() === 1)
  }

  it should "throw NoSuchElementException if an empty stack is popped" in {
    val emptyStack = new Stack[String]
    assertThrows[NoSuchElementException] {
      emptyStack.pop()
    }
  }
}

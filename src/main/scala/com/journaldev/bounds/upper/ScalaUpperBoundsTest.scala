package com.journaldev.bounds.upper

import com.journaldev.bounds.{Animal, Dog}

/**
  * Created by diam on 5/14/2018.
  */
object ScalaUpperBoundsTest extends App {

  val animal = new Animal
  val dog = new Dog
  val puppy = new Puppy

  val animalCarer = new AnimalCarer

  //animalCarer.display(animal)
  animalCarer.display(dog)
  animalCarer.display(puppy)
}

class Puppy extends Dog

class AnimalCarer{
  def display [T <: Dog](t: T){
    println(t)
  }
}

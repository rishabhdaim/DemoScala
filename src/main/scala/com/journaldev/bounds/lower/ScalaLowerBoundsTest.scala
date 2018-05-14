package com.journaldev.bounds.lower

import com.journaldev.bounds.{Animal, Dog}

/**
  * Created by diam on 5/14/2018.
  */
object ScalaLowerBoundsTest extends App {

  val animal = new Animal
  val dog = new Dog
  val puppy = new Puppy

  val animalCarer = new AnimalCarer

  animalCarer.display(animal)
  animalCarer.display(puppy)
  animalCarer.display(dog)
}

class Puppy extends Animal

class AnimalCarer{
  def display [T >: Puppy](t: T){
    println(t)
  }
}

package book.programinscala.abstraction

/**
  * Created by diam on 6/26/2018.
  */

class Food
class Grass extends Food
class Fish extends Food

abstract class Animal {
  type SuitableFood <: Food
  def eat(food: SuitableFood)
}

class Cow extends Animal {

  override type SuitableFood = Grass
  override def eat(food: Grass): Unit = {
    println("Cow Eating Grass")
  }
}

class Shark extends Animal {
  override type SuitableFood = Fish

  override def eat(food: Fish): Unit = {
    println("Shark eating Fish")
  }
}

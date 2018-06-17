package book.programinscala.packages

import scalafx.scene.paint.Color

/**
  * Created by diam on 6/16/2018.
  */
trait Fruit {
  val name: String
  val color: Color
}

object Fruits {
  object Apple extends Fruit {
    override val name: String = "Apple"
    override val color: Color = Color.Red
  }

  object Orange extends Fruit {
    override val name: String = "Orange"
    override val color: Color = Color.Orange
  }

  object Pear extends Fruit {
    override val name: String = "Pear"
    override val color: Color = Color.LightGreen
  }

  val menu = List(Apple, Orange, Pear)
}

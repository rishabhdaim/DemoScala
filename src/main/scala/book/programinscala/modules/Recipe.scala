package book.programinscala.modules

/**
  * Created by diam on 7/11/2018.
  */
abstract class Recipe(val name: String, val ingredients: List[Food], val instructions: String) {
  override def toString = name
}
object CreamFruitSalad extends Recipe("cream fruit salad", List(Apple, Orange, Cream, Sugar), "Stir it all together.")

package book.programinscala.modules

/**
  * Created by diam on 7/11/2018.
  */
object SimpleDatabase extends Database with SimpleFoods with SimpleRecipes {
  override def allFoods = List(Apple, Orange, Cream, Sugar)
  override def allRecipes: List[Recipe] = List(FruitSalad, CreamFruitSalad)
  override def allCategories = List(FoodCategory("fruits", List(Apple, Orange)), FoodCategory("misc", List(Cream, Sugar)))
}

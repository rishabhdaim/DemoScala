package book.programinscala.modules

/**
  * Created by diam on 7/11/2018.
  */
abstract class Database extends FoodCategories {
  def allFoods: List[Food]
  def allRecipes: List[Recipe]
  def allCategories: List[FoodCategory]
  def foodNamed(name: String) = allFoods.find(f => f.name == name)
}

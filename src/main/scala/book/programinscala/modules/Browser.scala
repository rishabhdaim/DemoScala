package book.programinscala.modules

/**
  * Created by diam on 7/11/2018.
  */
abstract class Browser {

  val database: Database
  def recipesUsing(food: Food): List[Recipe] = database.allRecipes.filter(recipe => recipe.ingredients.contains(food))

  def displayCategory(category: database.FoodCategory) {
    println(s"Name : ${category.name}")
  }
}

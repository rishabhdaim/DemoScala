package book.programinscala.modules

/**
  * Created by diam on 7/11/2018.
  */
trait SimpleRecipes {
  self: SimpleDatabase.type =>
    object FruitSalad extends Recipe("fruit salad", List(Apple, Pear), "Mix it all together.")
    def allRecipes: List[Recipe] = List(FruitSalad)
}

package book.programinscala.modules

/**
  * Created by diam on 7/11/2018.
  */
trait SimpleFoods {
  self: SimpleDatabase.type =>
    object Pear extends Food("Pear")
    def allFoods = List(Apple, Pear)
    def allCategories: List[FoodCategory]
}

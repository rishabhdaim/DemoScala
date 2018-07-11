package book.programinscala.modules

/**
  * Created by diam on 7/11/2018.
  */
trait FoodCategories {
  case class FoodCategory(name: String, foods: List[Food])
}

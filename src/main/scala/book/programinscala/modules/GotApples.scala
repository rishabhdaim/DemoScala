package book.programinscala.modules

/**
  * Created by diam on 7/11/2018.
  */
object GotApples extends App {
  val db: Database = if(args(0) == "student") StudentDatabase else SimpleDatabase

  object browser extends Browser {
    val database: db.type = db
  }
  val apple = SimpleDatabase.foodNamed("Apple").get
  for(recipe <- browser.recipesUsing(apple))
    println(recipe)

  println("----------------------------")
  val cream = SimpleDatabase.foodNamed("Cream").get
  for(recipe <- browser.recipesUsing(cream))
    println(recipe)

  println("----------------------------")
  for (category <- db.allCategories)
    browser.displayCategory(category)
}

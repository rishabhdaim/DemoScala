package book.programinscala.traits

/**
  * Created by diam on 6/13/2018.
  */
abstract class BaseBook(val author: String, val title: String) {
  override def hashCode = {
    Thread.sleep(3000) // a very slow hashCode function
    author.hashCode + title.hashCode
  }
}

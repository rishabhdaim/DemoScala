package book.programinscala.traits

/**
  * Created by diam on 6/13/2018.
  */
class Book(override val author: String, override val title: String)
  extends BaseBook(author, title) with Ordered[Book] with HashScrambling with HashCaching {

  def compare(that: Book): Int = {
    if (author < that.author) -1
    else if (author > that.author) 1
    else if (title < that.title) -1
    else if (title > that.title) 1
    else 0
  }
  override def equals(that: Any) =
    that match {
      case that: Book => compare(that) == 0
      case _ => false
    }

  /** The hash code computation is abstract */
  def computeHash: Int = author.hashCode + title.hashCode
}


/**
  * Created by diam on 4/17/2018.
  */
class ScalaType {

  val d = new Document

  d.setTitle("Scala").setAuthor("Arney")

  println(d)

  var book = new Book

  book.setAuthor("sethi").setChapter("Introduction to Scala").setTitle("Scala")

  println(book)

  book = new Book

  book set Title to "Scala for the impatient"

  println(book)

}

object ScalaType {

  def main(args: Array[String]) {
    val st = new ScalaType
  }
}

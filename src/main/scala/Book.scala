/**
  * Created by diam on 4/17/2018.
  */
class Book extends Document{

  var chapter = ""

  def setChapter(chapter: String): this.type = {
    this.chapter = chapter;
    this;
  }


  override def toString = s"Book(chapter=$chapter, ${super.toString})"
}

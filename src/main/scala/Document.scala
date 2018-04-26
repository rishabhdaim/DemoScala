/**
  * Created by diam on 4/17/2018.
  */

object Title

class Document {

  var author = "";
  var title = "";

  private var useNextArgs : Any = null

  def set(obj : Title.type ) : this.type = {this.useNextArgs = obj; this}

  def to (arg: String) = if (this.useNextArgs == Title) title = arg; else title = null

  def setTitle(title: String): this.type = {
    this.title = title;
    this;
  }

  def setAuthor(author: String): this.type = {
    this.author = author;
    this;
  }

  override def toString = s"Document($author, $title)"
}

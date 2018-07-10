package book.programinscala.extractors

/**
  * Created by diam on 7/10/2018.
  */
object Domain {
  def apply(parts: String*): String = parts.reverse.mkString(".")
  def unapplySeq(whole: String): Option[Seq[String]] = Some(whole.split("\\.").reverse)
}

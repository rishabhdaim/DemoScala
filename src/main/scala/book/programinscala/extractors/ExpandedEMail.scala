package book.programinscala.extractors

/**
  * Created by diam on 7/10/2018.
  */
object ExpandedEMail {
  def unapplySeq(email: String) : Option[(String, Seq[String])] = {
    val parts = email.split("@")
    if (parts.length == 2) {
      val arr: Seq[String] = parts(1).split("\\.").reverse
      Some(parts(0), arr)
    }
    else
      None
  }
}

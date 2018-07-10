package book.programinscala.extractors

/**
  * Created by diam on 7/5/2018.
  */

// An extractor object
object EMail {

  def apply(user: String, domain: String): String = user + "@" + domain

  def unapply(email: String): Option[(String, String)] = {
    val parts = email split "@"
    if (parts.length == 2) Some(parts(0), parts(1)) else None
  }
}

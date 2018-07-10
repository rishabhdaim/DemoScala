package book.programinscala.extractors

/**
  * Created by diam on 7/10/2018.
  */
object Twice {
  def apply(s: String) = s + s
  def unapply(s: String) = {
    val l = s.length / 2
    val half = s.substring(0, l)
    if (half == s.substring(l)) Some(half) else None
  }
}



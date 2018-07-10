package book.programinscala.extractors

/**
  * Created by diam on 7/10/2018.
  */
object UpperCase {
  def unapply(s: String) = s.toUpperCase == s
}

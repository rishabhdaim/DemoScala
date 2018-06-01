package book.programinscala

/**
  * Created by diam on 5/31/2018.
  */
object FileMatcher extends App {

  private def filesHere = new java.io.File(".").listFiles

  def filesEnding(query: String) = filesMatching(_.endsWith(query))

  def filesContaining(query: String) = filesMatching(a => a.contains(query))

  def filesRegex(query: String) = filesMatching(query, _.matches(_))

  private def filesMatching(query: String, matcher: (String, String) => Boolean) =
    for (file <- filesHere; if matcher(file.getName, query)) yield file

  private def filesMatching(matcher: String => Boolean) =
    for (file <- filesHere; if matcher(file.getName)) yield file

  def containsZero(nums: List[Int]) = nums.exists(_ == 0)
}

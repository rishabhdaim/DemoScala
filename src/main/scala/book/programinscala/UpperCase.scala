package book.programinscala

/**
  * Created by diam on 5/24/2018.
  */
object UpperCase extends App {

  def hasUpper(s: String) : Boolean = {
    s.exists(_.isUpper)
  }

  def hasUpperCase(s: String) : Boolean = {
    for (i <- 0 until s.length) {
      if (Character.isUpperCase(s.charAt(i))) {
        return true
      }
    }
    return false
  }

  println(hasUpper("Rishabh"))
  println(hasUpperCase("Rishabh"))
}

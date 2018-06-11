package book.programinscala.elements

/**
  * Created by diam on 6/12/2018.
  */
private class LineElement(s: String) extends Element {
  val contents = Array(s)
  override def width = s.length
  override def height = 1
}

package book.programinscala.elements

/**
  * Created by diam on 6/12/2018.
  */
private class LineElement2(s: String) extends ArrayElement(Array(s)) {
  override def width = s.length
  override def height = 1
}

package book.programinscala.elements

/**
  * Created by diam on 6/12/2018.
  */
private class UniformElement(ch: Char, override val width: Int, override val height: Int) extends Element {
  private val line = new String(Array.fill(width)(ch))
  def contents = Array.fill(height)(line)
}

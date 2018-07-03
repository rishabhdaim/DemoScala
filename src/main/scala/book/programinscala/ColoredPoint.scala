package book.programinscala

/**
  * Created by diam on 7/3/2018.
  */
class ColoredPoint(x: Int, y: Int, val color: Color.Value) extends Point(x, y) {

  override def hashCode = super.hashCode * 41 + color.hashCode
  override def equals(other: Any) : Boolean = other match {
    case that: ColoredPoint =>
      super.equals(that) && (this.color == that.color)
    case _ => false
  }

  override def isComparable(other: Any) : Boolean = other.isInstanceOf[ColoredPoint]
}

object Color extends Enumeration {
  val red, green, blue = Value
}

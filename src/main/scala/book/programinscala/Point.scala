package book.programinscala

/**
  * Created by diam on 7/3/2018.
  */
class Point(val x: Int, val y: Int) {

  override def hashCode = x * 41 + y
  override def equals(other: Any) : Boolean = other match {
    case that: Point => (this.x == that.x) && (this.y == that.y) && (that isComparable this)
    case _ => false
  }

  def isComparable(other: Any) : Boolean = other.isInstanceOf[Point]
}

object Point extends App {
  val p1 = new Point(1, 2)
  val p2 = new Point(1, 2)

  println("P1 == P2 " + (p1 equals p2))
  println("P2 == P1 " + (p2 equals p1))

  val cp1 = new ColoredPoint(1, 2, Color.red)
  val cp2 = new ColoredPoint(1, 2, Color.red)
  println("CP1 == CP2 " + (cp1 equals cp2))
  println("CP2 == CP1 " + (cp2 equals cp1))

  println("CP1 == P1 " + (cp1 equals p1))
  println("P2 == CP2 " + (p2 equals cp2))
}

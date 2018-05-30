package book.programinscala

/**
  * Created by diam on 5/29/2018.
  */
class Rational(n: Int, d: Int) {


  def this(n: Int) = this(n, 1)

  def +(that: Rational) = new Rational(numer * that.denom + that.numer * denom, denom * that.denom)
  def -(that: Rational) = new Rational(numer * that.denom - that.numer * denom, denom * that.denom)
  def *(that: Rational) = new Rational(numer * that.numer, denom * that.denom)
  def /(that: Rational) = new Rational(numer * that.denom, denom * that.numer)
  def <(that: Rational) = this.numer * that.denom < that.numer * this.denom
  def max(that: Rational) = if (this < that) that else this

  def +(that: Int): Rational = this + new Rational(that)
  def -(that: Int): Rational = this - new Rational(that)
  def *(that: Int): Rational = this * new Rational(that)
  def /(that: Int): Rational = this / new Rational(that)

  override def toString = s"Rational($numer/$denom)"

  // private methods
  private def gcd(a: Int, b: Int) : Int = {
    if (b == 0) a else gcd(b, a % b)
  }

  private val g = gcd(n, d)

  val numer: Int = n / g
  val denom: Int = d / g
}

object Rational extends App {

  // for implicit conversion from Int to Rationals
  implicit def intToRational(x: Int) = new Rational(x)

  val r1 = new Rational(1,3)
  println(r1)

  val r2 = new Rational(5, 7)
  println(r2)

  val r3 = new Rational(3, 2)
  println(r3)

  println(r1.+(r2).*(r3))
  println(r1 + r2 * r3)

  println(2 * r1)
}

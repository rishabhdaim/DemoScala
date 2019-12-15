package book.programinscala.typeclasses

sealed trait ExpressionValue

case class Number(value: Int) extends ExpressionValue
case class Plus(lhs: ExpressionValue, rhs: ExpressionValue) extends ExpressionValue
case class Minus(lhs: ExpressionValue, rhs: ExpressionValue) extends ExpressionValue


object ExpressionValue extends App {
  def evaluate(value: ExpressionValue): Int = {
    value match {
      case v@Number(_) => v.value
      case v@Plus(_, _) => evaluate(v.lhs) + evaluate(v.rhs)
      case v@Minus(_, _) => evaluate(v.lhs) - evaluate(v.rhs)
    }
  }

  def evaluate[A: Expression](value: A): Int = {
    evaluate(implicitly[Expression[A]].value(value))
  }

  println(evaluate((1, (2, 3))))
}
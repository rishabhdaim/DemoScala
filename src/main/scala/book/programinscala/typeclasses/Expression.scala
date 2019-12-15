package book.programinscala.typeclasses

trait Expression[A] {
  def value(expr: A): ExpressionValue
}

object Expression {

  implicit val intExpression: Expression[Int] = (expr: Int) => Number(expr)

  implicit def plusExpression[T1: Expression, T2: Expression]: Expression[(T1, T2)] =
    (expr: (T1, T2)) => Plus(implicitly[Expression[T1]].value(expr._1), implicitly[Expression[T2]].value(expr._2))

  implicit def minusExpression[T1: Expression, T2: Expression]: Expression[(T1, T2)] =
    (expr: (T1, T2)) => Minus(implicitly[Expression[T1]].value(expr._1), implicitly[Expression[T2]].value(expr._2))
}

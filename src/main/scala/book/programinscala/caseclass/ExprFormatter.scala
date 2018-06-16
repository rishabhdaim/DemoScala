package book.programinscala.caseclass

import book.programinscala.elements.Element

import scala.collection.immutable.IndexedSeq

/**
  * Created by diam on 6/16/2018.
  */
class ExprFormatter {

  /** Contains all operators in groups of increasing precedence */
  protected val opGroups = Array(
      Set("|", "||"),
      Set("&", "&&"),
      Set("ˆ"),
      Set("==", "!="),
      Set("<", "<=", ">", ">="),
      Set("+", "-"),
      Set("*", "%")
    )
  /** A mapping from operators to their precedence */
  private val precedence: Map[String, Int] = {
    val assocs: IndexedSeq[(String, Int)] =
      for {i <- opGroups.indices
           op <- opGroups(i)
      } yield op -> i
    Map() ++ assocs
  }

  protected val unaryPrecedence = opGroups.length
  protected val fractionPrecedence = -1

  private def format(e: Expr, enclPrec: Int = 0) : Element = e match {
    case Var(name) => Element.elem(name)
    case Number(num) =>
      def stripDot(s: String) =
        if (s endsWith ".0") s.substring(0, s.length - 2) else s
      Element.elem(stripDot(num.toString))
    case UnOp(op, arg) => Element.elem(op) beside format(arg, unaryPrecedence)
    case BinOp("/", left, right) =>
      val top = format(left, fractionPrecedence)
      val bot = format(right, fractionPrecedence)
      val line = Element.elem('-', top.width max bot.width, 1)
      val frac = top above line above bot
      if (enclPrec != fractionPrecedence) frac
      else Element.elem(" ") beside frac beside Element.elem(" ")
    case BinOp(op, left, right) =>
      val opPrec = precedence(op)
      val l = format(left, opPrec)
      val r = format(right, opPrec + 1)
      val oper = l beside Element.elem(" "+op+" ") beside r
      if (enclPrec <= opPrec) oper
      else Element.elem("(") beside oper beside Element.elem(")")
  }
}

object ExprFormatter extends App {
  val f = new ExprFormatter
  val e1 = BinOp("*", BinOp("/", Number(1), Number(2)), BinOp("+", Var("x"), Number(1)))
  val e2 = BinOp("+", BinOp("/", Var("x"), Number(2)), BinOp("/", Number(1.5), Var("x")))
  val e3 = BinOp("/", e1, e2)
  def show(e: Expr) = println(e+":\n"+ f.format(e)+"\n")
  for (e <- Array(e1, e2, e3)) show(e)
}

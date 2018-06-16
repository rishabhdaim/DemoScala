package book.programinscala.caseclass

/**
  * Created by diam on 6/16/2018.
  */
sealed abstract class Expr

case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

object Expr extends App {

  def simplifyTop(expr: Expr) : Expr = expr match {
    case UnOp("-", UnOp("-", e)) => e // Double negation
    case BinOp("+", e, Number(0)) => e // Adding zero
    case BinOp("*", e, Number(1)) => e // Multiplying by one
    case UnOp("abs", e@UnOp("abs", _)) => e // variable binding if pattern matches
    case _ => expr
  }

  // using pattern guard
  def simplifyAdd(expr: Expr) : Expr = expr match {
    case BinOp("+", x, y) if x == y => BinOp("*", x , Number(2))
    case _ => expr
  }

  def simplifyAny(expr: Expr): Expr = expr match {
    case UnOp("-", UnOp("-", e)) => e // ‘-' is its own inverse
    case BinOp("+", e, Number(0)) => e // ‘0' is a neutral element for ‘+'
    case BinOp("*", e, Number(1)) => e // ‘1' is a neutral element for ‘*'
    case UnOp(op, e) => UnOp(op, simplifyAny(e))
    case BinOp(op, l, r) => BinOp(op, simplifyAny(l), simplifyAny(r))
    case _ => expr
  }

  def simplifyDescribe(expr: Expr) : String = (expr : @unchecked) match {
    case Number(x) => "A Number"
    case Var(_) => "A variable"
    case UnOp(_, _) => "A Unary Operator"
    case BinOp(_, _, _) => "A Binary Operator"
    case _ => throw new RuntimeException // Should not happen
  }

  def matchAll(expr: Expr) : Unit = expr match {
    case BinOp(_, _, _) => println(expr + " is a binary expression")
    case _ => println("Something else")
  }

  def describe(x: Any): String = x match {
    case 5 => "five"
    case true => "truth"
    case "hello" => "hi!"
    case math.Pi => "strange math? Pi = "+ math.Pi
    case Nil => "the empty list"
    case somethingElse => "something else " + somethingElse
  }

  def listMatch(list: Seq[Int]) : Unit = list match {
    case List(0, _, _) => println("list starting with 0 and length is 3")
    case List(0, _*) => println("list starting with 0 with any length")
    case _ => println("No list found")
  }

  def generalSize(x: Any): Int = x match {
     case s: String => s.length
     case m: Map[_, _] => m.size
     case l: List[_] => l.size
     case _ => -1
  }

  def isIntIntMap(x : Any) : Boolean = x match {
    case m: Map[Int, Int] => true
    case _ => false
  }

  def isStringArray(x : Any) : Boolean = x match {
    case a: Array[String] => true
    case _ => false
  }

  println(simplifyTop(UnOp("-", UnOp("-", Var("X")))))
  println(simplifyTop(UnOp("abs", UnOp("abs", Var("Y")))))
  println(simplifyAdd(BinOp("+", Number(2), Number(3))))
  println(simplifyAdd(BinOp("+", Number(2), Number(2))))
  println(describe(UnOp("-", UnOp("-", Var("X")))))
  println(describe(Math.PI))
  listMatch(List(0, 1))
  listMatch(List(1, 2))

  val map = Map(1 -> 2, 2 -> 3, 3 -> 4, 4 -> 5, 5 -> 6)
  println("size of string : " + generalSize("abc"))
  println("size of List : " + generalSize(List(1,2,3,4,5)))
  println("size of Map : " + generalSize(map))
  println("size of Number : " + generalSize(234))
  matchAll(UnOp("-", UnOp("-", Var("X"))))
  println(isIntIntMap("Int Map : " + map))
  println(isIntIntMap("Int Map : " + Map("abc" -> "abc"))) // returns true because of type erasure
  println(isStringArray("String Array : " + Array(1,2)))
  println(isStringArray("String Array : " + Array("1","2")))
}
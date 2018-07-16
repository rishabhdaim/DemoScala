package book.programinscala.parsers

import scala.util.parsing.combinator.syntactical.StandardTokenParsers

/**
  * expr ::= term {'+' term | '-' term}.
  * term ::= factor {'*' factor | '/' factor}.
  * factor ::= numericLit | '(' expr ')'.
  *
  * Created by diam on 7/16/2018.
  */
class Arith extends StandardTokenParsers {
  lexical.delimiters ++= List("(", ")", "+", "-", "*", "/")
  def expr : Parser[Any] = term ~ rep("+" ~ term | "-" ~ term)
  def term : Parser[Any] = factor ~ rep("*" ~ factor | "/" ~ factor)
  def factor: Parser[Any] = "(" ~ expr ~ ")" | numericLit
}

object ArithTest extends Arith with App {
  for (e <- args) {
    val tokens = new lexical.Scanner(e)
    println("input: "+e)
    println(phrase(expr)(tokens))
  }
}

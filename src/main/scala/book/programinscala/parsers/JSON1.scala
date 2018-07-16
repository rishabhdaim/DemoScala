package book.programinscala.parsers

import scala.util.parsing.combinator.syntactical.StandardTokenParsers
import scala.util.parsing.input.StreamReader

/**
  * Created by diam on 7/16/2018.
  */
class JSON1 extends StandardTokenParsers {
  lexical.delimiters += ("{", "}", "[", "]", ":", ",")
  lexical.reserved += ("null", "true", "false")
  def obj: Parser[Map[String, Any]] = "{" ~> repsep(member, ",") <~ "}" ^^ (Map() ++ _)
  def arr: Parser[List[Any]] = "[" ~> repsep(value, ",") <~ "]"
  def member: Parser[(String, Any)] = stringLit ~ ":" ~ value ^^ { case name ~ ":" ~ value => (name, value) }
  def value: Parser[Any] = obj | arr | stringLit | numericLit ^^ (_.toInt) | "null" ^^^ null | "true" ^^^ true | "false" ^^^ false
}

object JSON1Test extends JSON1 with App {
  val reader = StreamReader(new java.io.FileReader(args(0)))
  val tokens = new lexical.Scanner(reader)
  println(phrase(value)(tokens))
}

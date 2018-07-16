package book.programinscala.parsers

import scala.util.parsing.combinator.syntactical.StandardTokenParsers
import scala.util.parsing.input.StreamReader

/**
  * Created by diam on 7/16/2018.
  */
class JSON extends StandardTokenParsers {
  lexical.delimiters += ("{", "}", "[", "]", ":", ",")
  lexical.reserved += ("null", "true", "false")
  def value : Parser[Any] = obj | arr | stringLit | numericLit | "null" | "true" | "false"
  def obj : Parser[Any] = "{" ~ repsep(member, ",") ~ "}"
  def arr : Parser[Any] = "[" ~ repsep(value, ",") ~ "]"
  def member: Parser[Any] = stringLit ~ ":" ~ value
}

object JSONTest extends JSON with App {
  val reader = StreamReader(new java.io.FileReader(args(0)))
  val tokens = new lexical.Scanner(reader)
  println(phrase(value)(tokens))
}

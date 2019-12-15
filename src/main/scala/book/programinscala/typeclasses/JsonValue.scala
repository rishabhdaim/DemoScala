package book.programinscala.typeclasses
sealed trait JsonValue

case class JsonObject (v: Map[String, JsonValue]) extends JsonValue
case class JsonArray (v: Seq[JsonValue]) extends JsonValue
case class JsonString (v: String) extends JsonValue
case class JsonNumber (v: BigDecimal) extends JsonValue
case class JsonBoolean (v: Boolean) extends JsonValue
case object JsonNull extends JsonValue

object JsonWriter extends App {
  def write(value: JsonValue): String = value match {
    case JsonObject(v) =>
      val result = for ((key, value) <- v) yield key + ": " + write(value)
      result.mkString(" {" , ", ", " }")
    case JsonArray(v) => (v map write) mkString("[ ", ", ", " ]")
    case JsonString(v) => v
    case JsonNumber(v) => v toString
    case JsonBoolean(v) => v toString
    case JsonNull => "null"
  }

  def write[A: Json](value: A): String = {
    write(implicitly[Json[A]].json(value))
  }
  println(write((1, (2, 3))))
}

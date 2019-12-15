package book.programinscala.typeclasses

trait Json[A] {
  def json(value: A): JsonValue
}

object Json {
  implicit val intToJson: Json[Int] = (value: Int) => JsonNumber(value)

  implicit def pairToJson[T1: Json, T2: Json]: Json[(T1, T2)] = (pair: (T1, T2)) => JsonObject(
    Map("fst" -> implicitly[Json[T1]].json(pair._1), "snd" -> implicitly[Json[T2]].json(pair._2))
  )

  implicit def seqToJson[A: Json]: Json[Seq[A]] = (value: Seq[A]) => JsonArray(
    value.map(implicitly[Json[A]].json))
}

package book.programinscala.abstraction

/**
  * Created by diam on 6/26/2018.
  */
object Converter {
  var exchangeRate = Map(
    "USD" -> Map("USD" -> 1.0 , "EUR" -> 0.7596, "JPY" -> 1.211 , "CHF" -> 1.223, "INR" -> 68.74),
    "EUR" -> Map("USD" -> 1.316 , "EUR" -> 1.0 , "JPY" -> 1.594 , "CHF" -> 1.623, "INR" -> 84.23),
    "JPY" -> Map("USD" -> 0.8257, "EUR" -> 0.6272, "JPY" -> 1.0 , "CHF" -> 1.018, "INR" -> 0.64),
    "CHF" -> Map("USD" -> 0.8108, "EUR" -> 0.6160, "JPY" -> 0.982 , "CHF" -> 1.0, "INR" -> 26.14),
    "INR" -> Map("USD" -> 0.16, "EUR" -> 0.12, "JPY" -> 1.6 , "CHF" -> 0.23, "INR" -> 1.0)
  )
}

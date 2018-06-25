package book.programinscala.abstraction

/**
  * Created by diam on 6/26/2018.
  */
object European extends CurrencyZone {
  abstract class Euro extends AbstractCurrency
  type Currency = Euro
  def make(x: Long) = new Euro {
    val amount = x
    def designation = "EUR"
  }
  val Euro = make(100)
  val Cent = make(1)
  val CurrencyUnit = Euro
}

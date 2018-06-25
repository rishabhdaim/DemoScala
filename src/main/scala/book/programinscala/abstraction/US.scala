package book.programinscala.abstraction

/**
  * Created by diam on 6/26/2018.
  */
object US extends CurrencyZone {
  abstract class Dollar extends AbstractCurrency
  type Currency = Dollar
  def make(x: Long) = new Dollar {
    val amount = x
    def designation = "USD"
  }
  val Cent = make(1)
  val Dollar = make(100)
  val CurrencyUnit = Dollar
}

package book.programinscala.abstraction

/**
  * Created by diam on 6/26/2018.
  */
object Japan extends CurrencyZone {
  abstract class Yen extends AbstractCurrency
  type Currency = Yen
  def make(x: Long) = new Yen {
    val amount = x
    def designation = "JPY"
  }
  val Yen = make(1)
  val CurrencyUnit = Yen
}

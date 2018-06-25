package book.programinscala.abstraction

/**
  * Created by diam on 6/26/2018.
  */
object India extends CurrencyZone {

  abstract class Rupee extends AbstractCurrency
  type Currency = Rupee

  def make(x: Long) = new Rupee {
    override def designation: String = "Rs"
    override val amount: Long = x
  }

  val Paisa = make(1)
  val Rupee = make(100)
  val CurrencyUnit = Rupee
}

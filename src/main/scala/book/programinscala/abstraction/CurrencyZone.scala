package book.programinscala.abstraction

/**
  * Created by diam on 6/26/2018.
  */
abstract class CurrencyZone {
  type Currency <: AbstractCurrency

  protected def make(x: Long): Currency
  val CurrencyUnit: Currency
  private def decimals(l: Long): Long = if (l == 1) 0 else 1 + decimals(l / 10)

  abstract class AbstractCurrency {
    val amount: Long
    def designation: String
    def +(that: Currency): Currency = make(this.amount + that.amount)
    def -(that: Currency): Currency = make(this.amount - that.amount)
    def *(that: Double) = make((this.amount * that).toLong)
    def /(that: Double) = make((this.amount / that).toLong)
    def /(that: Currency) = this.amount.toDouble / that.amount

    override def toString =
      (amount.toDouble / CurrencyUnit.amount.toDouble) formatted "%."+decimals(CurrencyUnit.amount)+"f"
    def from(other: CurrencyZone#AbstractCurrency): Currency =
      make(Math.round(other.amount.toDouble * Converter.exchangeRate(other.designation)(this.designation)))
  }

}

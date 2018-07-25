package book.effectiveakka.common

import akka.actor.ActorLogging
import akka.event.LoggingReceive

/**
  * Created by diam on 7/26/2018.
  */
class MoneyMarketAccountsProxyStub
  extends MoneyMarketAccountsProxy with ActorLogging {
  val accountData = Map[Long, List[(Long, BigDecimal)]](
    2L -> List((9L, BigDecimal(640000)), (10L, BigDecimal(1125000)), (11L, BigDecimal(40000))))
  def receive = LoggingReceive {
    case GetCustomerAccountBalances(id: Long) =>
      log.debug(s"Received GetCustomerAccountBalances for ID: $id")
      accountData.get(id) match {
        case Some(data) => sender ! MoneyMarketAccountBalances(Some(data))
        case None => sender ! MoneyMarketAccountBalances(Some(List()))
      }
  }
}

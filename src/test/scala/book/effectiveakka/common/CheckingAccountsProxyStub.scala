package book.effectiveakka.common

import akka.actor.ActorLogging
import akka.event.LoggingReceive

/**
  * Created by diam on 7/26/2018.
  */
class CheckingAccountsProxyStub extends CheckingAccountsProxy with ActorLogging {
  val accountData = Map[Long, List[(Long, BigDecimal)]](
    1L -> List((3L, BigDecimal(15000))),
    2L -> List((6L, BigDecimal(640000)), (7L, BigDecimal(1125000)), (8L, BigDecimal(40000))))
  def receive = LoggingReceive {
    case GetCustomerAccountBalances(id: Long) =>
      log.debug(s"Received GetCustomerAccountBalances for ID: $id")
      accountData.get(id) match {
        case Some(data) => sender ! CheckingAccountBalances(Some(data))
        case None => sender ! CheckingAccountBalances(Some(List()))
      }
  }
}

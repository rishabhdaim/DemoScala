package book.effectiveakka.common

import akka.actor.ActorLogging
import akka.event.LoggingReceive

/**
  * Created by diam on 7/26/2018.
  */
class SavingsAccountsProxyStub
  extends SavingsAccountsProxy with ActorLogging {
  val accountData = Map[Long, List[(Long, BigDecimal)]](
    1L -> List((1L, BigDecimal(150000)), (2L, BigDecimal(29000))),
    2L -> List((5L, BigDecimal(80000))))
  def receive = LoggingReceive {
    case GetCustomerAccountBalances(id: Long) =>
      log.debug(s"Received GetCustomerAccountBalances for ID: $id")
      accountData.get(id) match {
        case Some(data) => sender ! SavingsAccountBalances(Some(data))
        case None => sender ! SavingsAccountBalances(Some(List()))
      }
  }
}

package book.effectiveakka.common

import akka.actor.ActorLogging
import akka.event.LoggingReceive

/**
  * Created by diam on 7/26/2018.
  */
class TimingOutSavingsAccountProxyStub
  extends SavingsAccountsProxy with ActorLogging {
  def receive = LoggingReceive {
    case GetCustomerAccountBalances(id: Long) =>
      log.debug(s"Forcing timeout by not responding!")
  }
}

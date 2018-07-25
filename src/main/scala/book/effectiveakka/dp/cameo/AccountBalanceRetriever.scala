package book.effectiveakka.dp.cameo

import akka.actor.{Actor, ActorLogging, ActorRef}
import akka.event.LoggingReceive
import book.effectiveakka.common.GetCustomerAccountBalances

/**
  * Created by diam on 7/26/2018.
  */
class AccountBalanceRetriever(savingsAccounts: ActorRef, checkingAccounts: ActorRef, moneyMarketAccounts: ActorRef)
  extends Actor with ActorLogging {
  def receive = LoggingReceive {
    case GetCustomerAccountBalances(id) =>
      val originalSender = Some(sender)
      // I'm now using a factory method now from the companion object above!
      val handler = context.actorOf(
        AccountBalanceResponseHandler.props(savingsAccounts, checkingAccounts, moneyMarketAccounts,
          originalSender.get), "cameo-message-handler")
      savingsAccounts.tell(GetCustomerAccountBalances(id), handler)
      checkingAccounts.tell(GetCustomerAccountBalances(id), handler)
      moneyMarketAccounts.tell(GetCustomerAccountBalances(id), handler)
  }
}

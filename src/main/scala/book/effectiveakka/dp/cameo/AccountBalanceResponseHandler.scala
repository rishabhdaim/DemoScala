package book.effectiveakka.dp.cameo

import akka.actor.{Actor, ActorLogging, ActorRef, Cancellable, Props}
import akka.event.LoggingReceive
import book.effectiveakka.common._
import scala.language.postfixOps

import scala.concurrent.duration._

/**
  * Created by diam on 7/26/2018.
  */
class AccountBalanceResponseHandler(savingsAccounts: ActorRef, checkingAccounts: ActorRef, moneyMarketAccounts: ActorRef,
                                    originalSender: ActorRef) extends Actor with ActorLogging {
  var checkingBalances, savingsBalances, mmBalances: Option[List[(Long, BigDecimal)]] = None
  def receive = LoggingReceive {
    case CheckingAccountBalances(balances) =>
      log.debug(s"Received checking account balances: $balances")
      checkingBalances = balances
      collectBalances
    case SavingsAccountBalances(balances) =>
      log.debug(s"Received savings account balances: $balances")
      savingsBalances = balances
      collectBalances
    case MoneyMarketAccountBalances(balances) =>
      log.debug(s"Received money market account balances: $balances")
      mmBalances = balances
      collectBalances
    case AccountRetrievalTimeout =>
      log.debug("Timeout occurred")
      sendResponseAndShutdown(AccountRetrievalTimeout)
  }
  def collectBalances = (checkingBalances, savingsBalances, mmBalances) match {
    case (Some(c), Some(s), Some(m)) =>
      log.debug(s"Values received for all three account types")
      timeoutMessager.cancel
      sendResponseAndShutdown(AccountBalances(checkingBalances, savingsBalances, mmBalances))
    case _ =>
  }
  def sendResponseAndShutdown(response: Any) = {
    originalSender ! response
    log.debug("Stopping context capturing actor")
    context.stop(self)
  }
  import context.dispatcher
  val timeoutMessager: Cancellable = context.system.scheduler.scheduleOnce(250 milliseconds) {
      self ! AccountRetrievalTimeout
    }
}

object AccountBalanceResponseHandler {
  // Factory method for our actor Props
  def props(savingsAccounts: ActorRef, checkingAccounts: ActorRef, moneyMarketAccounts: ActorRef,
            originalSender: ActorRef): Props = {
    Props(new AccountBalanceResponseHandler(savingsAccounts, checkingAccounts, moneyMarketAccounts, originalSender))
  }
}

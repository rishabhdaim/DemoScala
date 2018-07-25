package book.effectiveakka.dp.extra

import akka.actor.{Actor, ActorLogging, ActorRef, Props}
import akka.event.LoggingReceive
import akka.util.Timeout
import book.effectiveakka.common._

import scala.concurrent.ExecutionContext
import scala.concurrent.duration._


/**
  * Created by diam on 7/26/2018.
  */
class AccountBalanceRetriever(savingsAccounts: ActorRef, checkingAccounts: ActorRef, moneyMarketAccounts: ActorRef)
  extends Actor with ActorLogging {


  implicit val timeout: Timeout = 100 milliseconds
  implicit val ec: ExecutionContext = context.dispatcher

  val checkingBalances, savingsBalances, mmBalances: Option[List[(Long, BigDecimal)]] = None
  var originalSender: Option[ActorRef] = None
  // always avoid `ASK` because it creates a new PromiseActorRef (a new actor)

  def receive = LoggingReceive {
    case GetCustomerAccountBalances(id) =>
      log.debug(s"Received GetCustomerAccountBalances for ID: $id from $sender")
      val originalSender = sender

      context.actorOf(Props(new Actor() {
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

        savingsAccounts ! GetCustomerAccountBalances(id)
        checkingAccounts ! GetCustomerAccountBalances(id)
        moneyMarketAccounts ! GetCustomerAccountBalances(id)
        val timeoutMessager = context.system.scheduler.scheduleOnce(250 milliseconds, self, AccountRetrievalTimeout)

      }))
  }
}

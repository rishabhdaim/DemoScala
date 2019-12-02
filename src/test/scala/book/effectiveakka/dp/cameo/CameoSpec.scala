package book.effectiveakka.dp.cameo

import akka.actor.{ActorSystem, Props}
import akka.testkit.{ImplicitSender, TestKit, TestProbe}
import book.effectiveakka.common._
import scala.language.postfixOps
import org.scalatest.matchers.must.Matchers;
import org.scalatest.wordspec.AnyWordSpecLike

import scala.concurrent.duration._

/**
  * Created by diam on 7/26/2018.
  */
class CameoSpec extends TestKit(ActorSystem("CameoTestAS")) with ImplicitSender with AnyWordSpecLike with Matchers {
  val checkingAccountsProxy = system.actorOf(Props[CheckingAccountsProxyStub], "checkings")
  val moneyMarketAccountsProxy = system.actorOf(Props[MoneyMarketAccountsProxyStub], "money-markets")
  "An AccountBalanceRetriever" should {
    "return a list of account balances" in {
      val probe1 = TestProbe()
      val probe2 = TestProbe()
      val savingsAccountsProxy = system.actorOf(Props[SavingsAccountsProxyStub], "cameo-success-savings")
      val checkingAccountsProxy = system.actorOf(Props[CheckingAccountsProxyStub], "cameo-success-checkings")
      val moneyMarketAccountsProxy = system.actorOf(Props[MoneyMarketAccountsProxyStub], "cameo-success-money-markets")
      val accountBalanceRetriever = system.actorOf(Props(new AccountBalanceRetriever(savingsAccountsProxy, checkingAccountsProxy,
        moneyMarketAccountsProxy)), "cameo-retriever1")
      within(300 milliseconds) {
        probe1.send(accountBalanceRetriever, GetCustomerAccountBalances(1L))
        val result = probe1.expectMsgType[AccountBalances]
        result must equal(AccountBalances(
          Some(List((3L, BigDecimal(15000)))),Some(List((1L, BigDecimal(150000)), (2L, BigDecimal(29000)))),
          Some(List())))
      }
      within(300 milliseconds) {
        probe2.send(accountBalanceRetriever, GetCustomerAccountBalances(2L))
        val result = probe2.expectMsgType[AccountBalances]
        result must equal(AccountBalances(
          Some(List((6L, BigDecimal(640000)), (7L, BigDecimal(1125000)), (8L, BigDecimal(40000)))),
          Some(List((5L, BigDecimal(80000)))),
          Some(List((9L, BigDecimal(640000)), (10L, BigDecimal(1125000)), (11L, BigDecimal(40000))))))
      }
    }
    "return a TimeoutException when timeout is exceeded" in {
      val savingsAccountsProxy = system.actorOf(Props[TimingOutSavingsAccountProxyStub], "cameo-timing-out-savings")
      val checkingAccountsProxy = system.actorOf(Props[CheckingAccountsProxyStub], "cameo-timing-out-checkings")
      val moneyMarketAccountsProxy = system.actorOf(Props[MoneyMarketAccountsProxyStub], "cameo-timing-out-money-markets")
      val accountBalanceRetriever = system.actorOf(Props(new AccountBalanceRetriever(savingsAccountsProxy, checkingAccountsProxy,
        moneyMarketAccountsProxy)), "cameo-timing-out-retriever")
      val probe = TestProbe()
      within(250 milliseconds, 500 milliseconds) {
        probe.send(accountBalanceRetriever, GetCustomerAccountBalances(1L))
        probe.expectMsg(AccountRetrievalTimeout)
      }
    }
  }
}

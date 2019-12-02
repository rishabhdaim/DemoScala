package book.effectiveakka.dp.extra

import akka.actor.{ActorSystem, Props}
import akka.testkit.{ImplicitSender, TestKit, TestProbe}
import book.effectiveakka.common._
import org.scalatest.matchers.must.Matchers;
import org.scalatest.wordspec.AnyWordSpecLike
import scala.language.postfixOps

import scala.concurrent.duration._

/**
  * Created by diam on 7/26/2018.
  */
class ExtraFinalSpec extends TestKit(ActorSystem("ExtraTestAS")) with ImplicitSender with AnyWordSpecLike with Matchers {
  "An AccountBalanceRetriever" should {
    "return a list of account balances" in {
      val probe1 = TestProbe()
      val probe2 = TestProbe()
      val savingsAccountsProxy = system.actorOf(Props[SavingsAccountsProxyStub], "extra-success-savings")
      val checkingAccountsProxy = system.actorOf(Props[CheckingAccountsProxyStub], "extra-success-checkings")
      val moneyMarketAccountsProxy = system.actorOf(Props[MoneyMarketAccountsProxyStub], "extra-success-money-markets")
      val accountBalanceRetriever = system.actorOf(Props(new AccountBalanceRetriever(savingsAccountsProxy,
          checkingAccountsProxy, moneyMarketAccountsProxy)), "extra-retriever")
      within(300 milliseconds) {
        probe1.send(accountBalanceRetriever, GetCustomerAccountBalances(1L))
        val result = probe1.expectMsgType[AccountBalances]
        result must equal(AccountBalances(
          Some(List((3L, BigDecimal(15000)))),
          Some(List((1L, BigDecimal(150000)), (2L, BigDecimal(29000)))),
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
      val savingsAccountsProxy = system.actorOf(Props[TimingOutSavingsAccountProxyStub], "extra-timing-out-savings")
      val checkingAccountsProxy = system.actorOf(Props[CheckingAccountsProxyStub], "extra-timing-out-checkings")
      val moneyMarketAccountsProxy = system.actorOf(Props[MoneyMarketAccountsProxyStub], "extra-timing-out-money-markets")
      val accountBalanceRetriever = system.actorOf(Props(new AccountBalanceRetriever(savingsAccountsProxy,
          checkingAccountsProxy, moneyMarketAccountsProxy)), "extra-timing-out-retriever")
      val probe = TestProbe()
      within(250 milliseconds, 500 milliseconds) {
        probe.send(accountBalanceRetriever, GetCustomerAccountBalances(1L))
        probe.expectMsg(AccountRetrievalTimeout)
      }}}}

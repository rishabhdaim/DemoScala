package book.programinscala.extractors

/**
  * Created by diam on 7/10/2018.
  */
object TestExtractor extends App {
  def test(s: String) = s match {
    case EMail(Twice(x @ UpperCase()), domain) =>
      "match: "+x+" in domain "+domain
    case _ =>
      "no match"
  }

  def dom(s: String) = s match {
    case Domain("org", "acm") => println("acm.org")
    case Domain("com", "sun", "java") => println("java.sun.com")
    case Domain("net", _*) => println("a .net domain")
  }

  def isTomInDotCom(s: String) = s match {
    case EMail("tom", Domain("com", _*)) => println(true)
    case _ => println(false)
  }

  println(test("DIDI@hotmail.com"))
  println(test("DIDO@hotmail.com"))
  println(test("didi@hotmail.com"))

  isTomInDotCom("tom@sun.com")
  isTomInDotCom("peter@sun.com")
  isTomInDotCom("tom@acm.org")

  val ExpandedEMail(name, topDomain, subDomains @ _*) = "tom@support.epfl.ch"
  println(name)
  println(topDomain)
  println(subDomains)
}

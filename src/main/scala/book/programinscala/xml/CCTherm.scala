package book.programinscala.xml

import scala.xml.Elem

/**
  * Created by diam on 7/3/2018.
  */
abstract class CCTherm {
  val description: String
  val yearMade: Int
  val dateObtained: String
  val bookPrice: Int // in pennies
  val purchasePrice: Int // in pennies
  val condition: Int // 110
  override def toString = description

  def toXML =
    <cctherm>
      <description>{description}</description>
      <yearMade>{yearMade}</yearMade>
      <dateObtained>{dateObtained}</dateObtained>
      <bookPrice>{bookPrice}</bookPrice>
      <purchasePrice>{purchasePrice}</purchasePrice>
      <condition>{condition}</condition>
    </cctherm>

  def fromXML(node: xml.Node): CCTherm =
    new CCTherm {
      val description = (node \ "description").text
      val yearMade = Integer.parseInt((node \ "yearMade").text)
      val dateObtained = (node \ "dateObtained").text
      val bookPrice = Integer.parseInt((node \ "bookPrice").text)
      val purchasePrice = Integer.parseInt((node \ "purchasePrice").text)
      val condition = Integer.parseInt((node \ "condition").text)
    }

  val catalog =
    <catalog>

      <cctherm>
        <description>hot dog thermometer</description>
        <yearMade>1952</yearMade>
        <dateObtained>March 14, 2006</dateObtained>
        <bookPrice>2199</bookPrice>
        <purchasePrice>500</purchasePrice>
        <condition>9</condition>
      </cctherm>

      <cctherm>
        <description>Sprite Boy thermometer</description>
        <yearMade>1964</yearMade>
        <dateObtained>April 28, 2003</dateObtained>
        <bookPrice>1695</bookPrice>
        <purchasePrice>595</purchasePrice>
        <condition>5</condition>
      </cctherm>

    </catalog>
}

object CCTherm extends App {
  val therm = new CCTherm {
    override val condition: Int = 9
    override val description: String = "hot dog thermometer"
    override val bookPrice: Int = 2199
    override val purchasePrice: Int = 500
    override val yearMade: Int = 1952
    override val dateObtained: String = "March 14, 2006"
  }

  private val elem: Elem = therm.toXML
  println(elem)
  println(therm.fromXML(elem))

  xml.XML.save("therm1.xml", elem, xmlDecl = true)

  println(therm.fromXML(xml.XML.loadFile("therm1.xml")))

  therm.catalog match {
    case <catalog>{therms @ _*}</catalog> =>
      for (therm @ <cctherm>{_*}</cctherm> <- therms)
        println("processing: " +(therm \ "description").text)
  }
}

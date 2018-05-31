package book.programinscala

import scala.io.Source

/**
  * Created by diam on 5/31/2018.
  */
object LongLines extends App {

  private def processFile(filename: String, width: Int) {

    def processLine(line: String) {
      if (line.length > width)
        println(filename+": "+line.trim)
    }

    val source = Source.fromFile(filename)
    for (line <- source.getLines)
      processLine(line)
  }

  processFile("build.sbt", 20)
}

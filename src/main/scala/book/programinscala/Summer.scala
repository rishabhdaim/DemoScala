package book.programinscala

import ChecksumCalculator.calcChecksum

/**
  * Created by diam on 5/29/2018.
  */
object Summer {
  def main(args: Array[String]) {
    for(arg <- args)
      println(arg + " : " + calcChecksum(arg))
  }
}

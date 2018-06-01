package book.programinscala

import java.io.{File, PrintWriter}
import java.util.Date

/**
  * Created by diam on 5/31/2018.
  */
object LoanPattern extends App {

  def withPrintWriter(file: File, op: PrintWriter => Unit) {
    val writer = new java.io.PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }

  def withPrintWriterClosure(file: File)(op: PrintWriter => Unit) {
    val writer = new java.io.PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }

  withPrintWriter(File.createTempFile("data", ".txt"), _.println(new Date))

  withPrintWriterClosure(File.createTempFile("data", ".txt")) {
    w => w.println(new Date)
  }

}

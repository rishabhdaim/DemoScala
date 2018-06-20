package book.programinscala.collections.seqs.arraybuffers

import scala.collection.mutable.ArrayBuffer

/**
  * Created by diam on 6/20/2018.
  */
class ArrayBuffers {
  val buf = new ArrayBuffer[Int]() // default size is 16
}

object ArrayBuffers extends App {
  val buffer = new ArrayBuffers

  println("Buffer Basic Add : ")
  buffer.buf += 1 // add to the end
  buffer.buf += 2 // add to the end
  buffer.buf.+=:(3) // prepend 3 to buffer
  4 +=: buffer.buf // prepend 4 to buffer, takes liner time
  println(buffer.buf)

  println("Conversions : ")
  println(buffer.buf.toArray.mkString(" "))
  println(buffer.buf.toList)
}
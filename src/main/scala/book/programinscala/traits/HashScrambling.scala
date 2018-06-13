package book.programinscala.traits

/**
  * Created by diam on 6/14/2018.
  */
trait HashScrambling {

  override def hashCode = {
    val original = super.hashCode
    def rl(i: Int) = Integer.rotateLeft(original, i)
    original ^ rl(8) ^ rl(16) ^ rl(24)
  }
}

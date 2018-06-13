package book.programinscala.traits

/**
  * Created by diam on 6/13/2018.
  */
trait HashCaching {

  /** A cache holding the computed hash. */
  private var cachedHash: Int = 0
  /** A boolean indicating whether the cache is defined */
  private var hashComputed: Boolean = false
  /** The hash code computation is abstract */
  def computeHash: Int
  /** Override the default Java hash computation */
  override def hashCode: Int = {
    if (!hashComputed) {
      cachedHash = super.hashCode
      hashComputed = true
    }
    cachedHash
  }
}

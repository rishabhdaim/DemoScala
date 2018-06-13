package book.programinscala.traits.stacking

/**
  * Created by diam on 6/14/2018.
  */
trait LoggingQueue extends Queue {

  private def log(message: String) = println(message)

  abstract override def get: Int = {
    val x = super.get
    log("got: " + x)
    x
  }
  abstract override def put(x: Int) {
    super.put(x)
    log("put: " + x)
  }
}

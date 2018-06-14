package book.programinscala.traits.stacking

/**
  * Created by diam on 6/14/2018.
  */
trait LoggingQueue extends Queue {

  private def log(message: String) = println(message)

  abstract override def get: Int = {
    log("got: log")
    val x = super.get
    x
  }
  abstract override def put(x: Int) {
    log("put: log")
    super.put(x)
  }
}

package book.programinscala.traits.stacking

/**
  * Created by diam on 6/14/2018.
  */
trait LockingQueue extends Queue {
  abstract override def get: Int = synchronized { println("Get Lock"); super.get }
  abstract override def put(x: Int) = synchronized { println("Put Lock"); super.put(x) }
}

package book.programinscala.collections.queues

/**
  * Created by diam on 6/22/2018.
  */
trait Queue[+T] {
  def head: T
  def tail: Queue[T]
  def append[U >: T](x: U): Queue[U]
}

object Queue {
  def apply[T](xs: T*): Queue[T] = new QueueImpl(xs.toList, Nil)

  private class QueueImpl[+T](private[this] var leading: List[T],
                              private[this] var trailing: List[T]) extends Queue[T] {

    def normalize() =
      if (leading.isEmpty) {
        while (trailing.nonEmpty) {
         leading = trailing.head :: leading
          trailing = trailing.tail
        }
      }

    def head: T = {
      normalize()
      leading.head
    }
    def tail: Queue[T] = {
      normalize()
      new QueueImpl[T](leading.tail, trailing)
    }

    def append[U >: T](x: U): Queue[U] = new QueueImpl[U](leading, x :: trailing)
  }
}

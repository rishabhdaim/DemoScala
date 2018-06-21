package book.programinscala.collections.queues

/**
  * Created by diam on 6/22/2018.
  */
class FuncQueue[+T] private (private[this] var leading: List[T], private[this] var trailing: List[T]) {

  def this() = this(Nil, Nil)

  def this(elems: T*) = this(elems.toList, Nil)

  private def mirror() =
    if (leading.isEmpty) {
      while (trailing.nonEmpty) {
        leading = trailing.head :: leading
        trailing = trailing.tail
      }
    }

  def head: T = {
    mirror()
    leading.head
  }
  def tail: FuncQueue[T] = {
    mirror()
    new FuncQueue[T](leading.tail, trailing)
  }

  def append[U >: T](x: U): FuncQueue[U] = new FuncQueue[U](leading, x :: trailing)
}

object FuncQueue {
  // constructs a queue with initial elements as given by ‘xs'
  def apply[T](leading: List[T], trailing: List[T]): FuncQueue[T] = new FuncQueue[T](leading, trailing)

  def apply[T](xs: T*): FuncQueue[T] = new FuncQueue[T](xs.toList, Nil)
}

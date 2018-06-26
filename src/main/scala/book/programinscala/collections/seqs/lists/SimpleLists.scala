package book.programinscala.collections.seqs.lists

/**
  * Created by diam on 6/18/2018.
  */
class SimpleLists {

  val fruits: List[String] = List("apple", "orange", "pears")
  val numbers: List[Int] = 1 :: (2 :: (3 :: (4 :: Nil)))
  val diagonal: List[List[Int]] = List(1, 0, 0) :: List(0, 1, 0) :: List(0, 0, 1) :: Nil
  val empty: List[Nothing] = List()
  val unsortedNums: List[Int] = List(2, 4, 1, 8, 3, 12, 1, 56, 4, 23, 45, 67)

//    if (xs.isEmpty) Nil else insert(xs.head, iSort(xs.tail))
  def iSort(xs: List[Int]): List[Int] = xs match {
    case List() => List()
    case x :: xs1 => insert(x, iSort(xs1))
  }
//    if (xs.isEmpty || x <= xs.head) x :: xs else xs.head :: insert(x, xs.tail)
  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case List() => List(x)
    case y :: ys => if (x <= y) x :: xs else y :: insert(x, ys)
  }

  def mSort[T](less: (T, T) => Boolean)(xs: List[T]): List[T] = {
    def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
      case (Nil, _) => ys
      case (_, Nil) => xs
      case (x :: xs1, y :: ys1) =>
        if (less(x, y)) x :: merge(xs1, ys) else y :: merge(xs, ys1)
    }
    val n = xs.length/2
    if (n == 0) xs
    else {
      val (ys, zs) = xs splitAt n
      merge(mSort(less)(ys), mSort(less)(zs))
    }
  }

  def hasZeroRow(m: List[List[Int]]) : Boolean = {
    m.exists(row => row.forall(_ == 0))
  }

  def sum(m: List[Int]) : Int = {
    (0 /: m)(_ + _)
  }

  def multiply(m: List[Int]) : Int = {
    (1 /: m)(_ * _)
  }
}

object SimpleLists extends App {

  val simpleLists = new SimpleLists
  println("Fruits : ")
  println(simpleLists.fruits)
  println(simpleLists.fruits.head)
  println(simpleLists.fruits.init)
  println(simpleLists.fruits.tail)
  println(simpleLists.fruits.last)

  println("Numbers : ")
  println(simpleLists.numbers.tail.head)
  println(simpleLists.numbers.tail)
  println(simpleLists.numbers.isEmpty)
  println(simpleLists.numbers(2))

  println("Diag3 : ")
  println(simpleLists.diagonal.head)
  println(simpleLists.diagonal.tail)

  println("Empty : ")
  println(simpleLists.empty.headOption.fold("Empty List") { e => e})
  println(simpleLists.empty.isEmpty)

  println("Sorting : ")
  println(simpleLists.unsortedNums)
  println(simpleLists.iSort(simpleLists.unsortedNums))
  println(simpleLists.mSort((x: Int, y: Int) => x < y)(simpleLists.unsortedNums))
  println(simpleLists.mSort((x: Int, y: Int) => x > y)(simpleLists.unsortedNums))
  println(simpleLists.mSort[Int]((x, y) => x > y)(simpleLists.unsortedNums))
  println(simpleLists.mSort[Int]( _ < _)(simpleLists.unsortedNums))

  println("List Pattern : ")
  val List(a, b, c) = simpleLists.fruits
  println(a)
  println(b)
  println(c)

  val i:: j :: rest = simpleLists.unsortedNums
  println(i)
  println(j)
  println(rest)

  println("List Concatenate : ")
  println(simpleLists.numbers ::: simpleLists.unsortedNums ::: simpleLists.iSort(simpleLists.unsortedNums))
  println((simpleLists.numbers ::: simpleLists.unsortedNums ::: simpleLists.iSort(simpleLists.unsortedNums)).reverse)

  println("Zip : ")
  println(simpleLists.fruits.indices zip simpleLists.fruits)
  println(simpleLists.fruits zip simpleLists.numbers)
  println(simpleLists.fruits.zipWithIndex.mkString("[", " -> ", "]"))

  println("Convert : ")
  println(simpleLists.unsortedNums.toArray.mkString(" "))
  println(simpleLists.unsortedNums.toArray.toList)

  println("Iterator : ")
  val it = simpleLists.numbers.iterator
  println(it.next())
  println(it.next())

  println("------------ : Higher Order functions : ---------------")
  println(simpleLists.numbers.map(_ + 1))
  println(simpleLists.fruits.map(_.length))
  println(simpleLists.fruits.map(_.toList.reverse.mkString("")))

  println("Map Vs FlatMap : ")
  println(simpleLists.fruits.map(_.toList))
  println(simpleLists.fruits.flatMap(_.toList))
  println(List.range(1, 5) flatMap (i => List.range(1, i) map (j => (i, j))))

  println("Filtering : ")
  println(simpleLists.unsortedNums.filter(_ % 2 == 0))
  println(simpleLists.unsortedNums.partition(_ % 2 == 0))
  println(simpleLists.unsortedNums.find(_ % 2 == 0))
  println(simpleLists.unsortedNums.takeWhile(_ < 50))
  println(simpleLists.unsortedNums.dropWhile(_ < 50))
  println(simpleLists.unsortedNums.span(_ < 50))
  println(simpleLists.hasZeroRow(simpleLists.diagonal))
  println(simpleLists.fruits.filter(_.length == 5))
  println(simpleLists.fruits.partition(_.length == 5))
  println(simpleLists.fruits.find(_.length == 5))

  println("Folding : ")
  println(simpleLists.sum(simpleLists.unsortedNums))
  println(simpleLists.multiply(simpleLists.unsortedNums))

  println(List.range(1, 9, 2))
  println(List.fill(5)(9))
  println(List.fill(5)("Hello!!"))
}

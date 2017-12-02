package problem

object P2 extends App {
  def penultimate[T](list: List[T]): T = list match {
    case x :: xs => {
      if (xs.length == 1) x
      else penultimate(xs)
    }
    case Nil => throw new NoSuchElementException
  }

  val list = List(1, 2, 3, 5, 6, 7, 8, 9, 10, 11, 1231, 1231, 123, 12, 33, 1, 5, 123, 123, 111111, 12312313)
  println(penultimate(list))
}
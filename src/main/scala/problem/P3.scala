package problem

object P3 extends App {
  def nth[T](n: Int, list: List[T]): T = (n, list) match {
    case (0, h :: _)    => h
    case (n, _ :: tail) => nth(n - 1, tail)
    case (_, Nil)       => throw new NoSuchElementException
  }

  val n = 22
  val list = List(1, 2, 3, 5, 6, 7, 8, 9, 10, 11, 1231, 1231, 123, 12, 33, 1, 5, 123, 123, 111111, 12312313)
  println(nth(n, list))
  println(list(n))
}
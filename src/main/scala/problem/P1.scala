package problem

object P1 extends App {
  def last[T](list: List[T]): T = list match {
    case x :: Nil => x
    case x :: xs  => last(xs)
    case Nil      => throw new NoSuchElementException
  }
  println(last(List(1, 3, 5, 6, 1, 22)))
}
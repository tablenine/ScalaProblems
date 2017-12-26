package problem

import scala.annotation.tailrec

object P22 extends App {

  // Builtin.
  def rangeBuiltin(start: Int, end: Int): List[Int] = List.range(start, end + 1)

  // Recursive.
  def rangeRecursive(start: Int, end: Int): List[Int] =
    if (end < start) Nil
    else start :: rangeRecursive(start + 1, end)

  // Tail recursive.
  def rangeTailRecursive(start: Int, end: Int): List[Int] = {
    def rangeR(end: Int, result: List[Int]): List[Int] = {
      if (end < start) result
      else rangeR(end - 1, end :: result)
    }
    rangeR(end, Nil)
  }

  // The classic functional approach would be to use `unfoldr`, which Scala
  // doesn't have.  So we'll write one and then use it.
  def unfoldRight[A, B](s: B)(f: B => Option[(A, B)]): List[A] =
    f(s) match {
      case None         => Nil
      case Some((r, n)) => r :: unfoldRight(n)(f)
    }
  def rangeFunctional(start: Int, end: Int): List[Int] =
    unfoldRight(start) { n =>
      if (n > end) None
      else Some((n, n + 1))
    }

  def range(s: Int, e: Int): List[Int] = {
    def subRange(s: Int, e: Int, result: List[Int]): List[Int] = {
      if (s > e) result
      else subRange(s + 1, e, result :+ s)
    }
    subRange(s, e, List())

  }
  val result = range(4, 9)
  println(result)
  val result2 = range(-2, 9)
  println(result2)
}
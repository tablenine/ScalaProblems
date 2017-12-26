package problem

import scala.annotation.tailrec

object P20 extends App {
  def removeAt[A](n: Int, ls: List[A]): (List[A], A) = ls.splitAt(n) match {
    case (Nil, _) if n < 0 => throw new NoSuchElementException
    case (pre, e :: post)  => (pre ::: post, e)
    case (pre, Nil)        => throw new NoSuchElementException
  }

  // Alternate, with fewer builtins.
  def removeAt2[A](n: Int, ls: List[A]): (List[A], A) =
    if (n < 0) throw new NoSuchElementException
    else (n, ls) match {
      case (_, Nil)       => throw new NoSuchElementException
      case (0, h :: tail) => (tail, h)
      case (_, h :: tail) => {
        val (t, e) = removeAt(n - 1, ls.tail)
        (ls.head :: t, e)
      }
    }
  def removeAt3[A](n: Int, ls: List[A]): (List[A], A) = {
    if (n >= ls.length || n < 0) throw new NoSuchElementException
    else (ls.take(n) ::: ls.drop(n + 1), ls.drop(n).take(n).head)
  }

  def removeAt4[A](n: Int, ls: List[A]): (List[A], A) = {
    def subRemoveAt(num: Int, tmpLs: List[A], resultList: List[A]): (List[A], A) = {
      if (num == 0) (resultList ::: tmpLs.tail, tmpLs.head)
      else subRemoveAt(num - 1, tmpLs.tail, resultList :+ tmpLs.head)
    }
    if (n >= ls.length || n < 0) throw new NoSuchElementException
    else subRemoveAt(n, ls, List())
  }
  val list = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
  val result = removeAt(10, list)
  val result2 = removeAt2(10, list)
  val result3 = removeAt3(10, list)
  val result4 = removeAt4(-1, list)
  println(result)
  println(result2)
  println(result3)
  println(result4)
}
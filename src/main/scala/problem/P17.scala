package problem

import scala.annotation.tailrec

object P17 extends App {
  def split[A](cnt: Int, ls: List[A]): (List[A], List[A]) = {
    ls.splitAt(cnt)
  }

  val ls = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
  val result1 = split(3, ls)
  println(result1)
}
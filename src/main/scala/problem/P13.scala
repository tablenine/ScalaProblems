package problem

import scala.annotation.tailrec

object P13 extends App {
  def encodeDirect[A](ls: List[A]): List[(Int, A)] = {
    @tailrec
    def subEncode(priv: A, tail: List[A], res: List[(Int, A)], cnt: Int): List[(Int, A)] = {
      if (tail.isEmpty) if (cnt > 1) res :+ (cnt, priv) else res
      else if (priv == tail.head) subEncode(tail.head, tail.tail, res, cnt + 1)
      else subEncode(tail.head, tail.tail, res :+ (cnt, priv), 1)
    }

    subEncode(ls.head, ls.tail, List(), 1)
  }
  def encodeDirect2[A](ls: List[A]): List[(Int, A)] =
    if (ls.isEmpty) Nil
    else {
      val (packed, next) = ls span { _ == ls.head }
      (packed.length, packed.head) :: encodeDirect(next)
    }

  val a = encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  val b = encodeDirect2(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  println(a)
  println(b)
  println(a == b)
}
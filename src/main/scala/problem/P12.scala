package problem

import scala.annotation.tailrec

object P12 extends App {
  def decode[A](ls: List[(Int, A)]): List[A] = {
    @tailrec
    def subDecode(cnt: Int, tail: List[(Int, A)], res: List[A]): List[A] = {
      if (tail.isEmpty) res
      else if (cnt < 2) subDecode(if (tail.tail.isEmpty) 0 else tail.tail.head._1, tail.tail, res :+ tail.head._2)
      else subDecode(cnt - 1, tail, res :+ tail.head._2)
    }

    subDecode(ls.head._1 - 1, if (ls.head._1 - 1 < 1) ls.tail else ls, List(ls.head._2))
  }

  val b = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
  val a = decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
  println(a)
  println(b)
  println(a == b)
}
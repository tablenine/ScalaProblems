package problem

import scala.annotation.tailrec

object P15 extends App {
  def duplicate[A](count: Int, ls: List[A]): List[A] = {
    @tailrec
    def sub(resultList: List[A], sList: List[A]): List[A] = {
      if (sList.isEmpty) resultList
      else {
        val ss = asfl(3, resultList, sList.head)
        sub(ss, sList.tail)
      }
    }

    @tailrec
    def asfl[A](cnt: Int, resultList: List[A], head: A): List[A] = {
      if (cnt == 0) resultList
      else asfl(cnt - 1, resultList :+ head, head)
    }
    sub(List(), ls)
  }

  val ls = List('a, 'b, 'c, 'c, 'd)
  val result = duplicate(3, ls)
  println(result)
}
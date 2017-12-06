package problem

import scala.annotation.tailrec

object P14 extends App {
  def duplicate[A](ls: List[A]): List[A] = {
    def sub(resultList: List[A], sList: List[A]): List[A] = {
      if (sList.isEmpty) resultList
      else sub(resultList :+ sList.head :+ sList.head, sList.tail)
    }

    sub(List(), ls)
  }

  def duplicate2[A](ls: List[A]): List[A] = ls flatMap { e => List(e, e) }
  val ls = List('a, 'b, 'c, 'c, 'd)
  val result = duplicate(ls)
  println(result)
  
  val result2 = duplicate2(ls)
  println(result2)
}
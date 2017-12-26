package problem

import scala.annotation.tailrec

object P21 extends App {
  def insertAt[A](el: A, num: Int, ls: List[A]): List[A] = {
    def sub(n: Int, list: List[A], result: List[A]): List[A] = {
      if (n == 0) (result :+ el) ::: list
      else sub(n - 1, list.tail, result :+ list.head)
    }
    if (num >= ls.length) ls :+ el
    else if (num < 0) throw new NoSuchElementException
    else sub(num, ls, List())
  }
  def insertAt2[A](e: A, n: Int, ls: List[A]): List[A] = ls.splitAt(n) match {
    case (pre, post) => pre ::: e :: post
  }
  val list = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
  val result = insertAt('new, 111, list)
  println(result)
  val result2 = insertAt('new, 1, list)
  println(result2)
  val result3 = insertAt('new, 7, list)
  println(result3)
  val result4 = insertAt('new, 0, list)
  println(result4)
  val result5 = insertAt2('new, 7, list)
  println(result5)
  println(result3 == result5)
}
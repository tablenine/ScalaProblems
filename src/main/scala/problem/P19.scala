package problem

import scala.annotation.tailrec

object P19 extends App {
  def rotate[A](n: Int, ls: List[A]): List[A] = {
    if (n == 0) ls
    else {
      if (n > 0) rotate(n - 1, ls.tail :+ ls.head)
      else rotate(n + 1, ls.last +: ls.init)
    }
  }

  def rotate2[A](n: Int, ls: List[A]): List[A] = {
    val nBounded = if (ls.isEmpty) 0 else n % ls.length
    if (nBounded < 0) rotate(nBounded + ls.length, ls)
    else (ls drop nBounded) ::: (ls take nBounded)
  }

  val list = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
  val result = rotate(3, list)
  val result2 = rotate(-2, list)
  val result3 = rotate2(3, list)
  val result4 = rotate2(-2, list)
  println(result)
  println(result2)
  println(result3)
  println(result4)
}
package problem

import scala.util.Random

object P24 extends App {
  import P23.randomSelect
  def lotto2(count: Int, max: Int): List[Int] =
    randomSelect(count, List.range(1, max + 1))

  def lotto(cnt: Int, max: Int): List[Int] = {
    def lottoR(c: Int, ls: List[Int]): List[Int] = {
      if (c == 0) ls
      else lottoR(c - 1, getInt(ls) :: ls)
    }

    def getInt(ls: List[Int]): Int = {
      val s = Random.nextInt(max - 1) + 1
      val b = ls.exists(l => l == s)
      if (b) getInt(ls)
      else s
    }
    lottoR(cnt, List())
  }

  val result = lotto(6, 49)
  println(result)
  val result2 = lotto(6, 49)
  println(result2)
}
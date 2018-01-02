package problem

import scala.util.Random

object P25 extends App {
  import P23.randomSelect
  def randomPermute[A](list: List[A]): List[A] = randomSelect(list.length, list)

//  // The canonical way to shuffle imperatively is Fisher-Yates.  It requires a mutable array.  This is O(n).
//  def randomPermute2[A](ls: List[A]): List[A] = {
//    val rand = new util.Random
//    val a = ls.toArray
//    for (i <- a.length - 1 to 1 by -1) {
//      val i1 = rand.nextInt(i + 1)
//      val t = a(i)
//      a.update(i, a(i1))
//      a.update(i1, t)
//    }
//    a.toList
//  }

  val list = List('a, 'b, 'c, 'd, 'e, 'f)
  val result = randomPermute(list)
  println(result)
//  val result2 = randomPermute2(list)
//  println(result2)
}
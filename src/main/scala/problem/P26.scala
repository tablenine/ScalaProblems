package problem

import scala.util.Random

object P26 extends App {
  // flatMapSublists is like list.flatMap, but instead of passing each element to the function, it passes successive sublists of L.
  def flatMapSublists[A, B](ls: List[A])(f: (List[A]) => List[B]): List[B] =
    ls match {
      case Nil                   => Nil
      case sublist @ (_ :: tail) => f(sublist) ::: flatMapSublists(tail)(f)
    }

  def combinations[A](n: Int, ls: List[A]): List[List[A]] =
    if (n == 0) List(Nil)
    else flatMapSublists(ls) { sl =>
      combinations(n - 1, sl.tail) map { sl.head :: _ }
    }

  val list = List('a, 'b, 'c, 'd, 'e, 'f)
  val result = combinations(3, list)
  println(result)
  //  val result2 = randomPermute2(list)
  //  println(result2)
}
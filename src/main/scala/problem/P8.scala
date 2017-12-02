package problem

object P8 extends App {
  def compress(list: List[Any]): List[Any] = {
    def subCompress(prev: Any, ls: List[Any], retList: List[Any]): List[Any] = {
      if (ls.tail.isEmpty) retList.reverse
      else if (prev == ls.head) subCompress(ls.head, ls.tail, retList)
      else subCompress(ls.head, ls.tail, ls.head :: retList)
    }

    subCompress(None, list, List())
  }

  // Standard recursive.
  def compressRecursive[A](ls: List[A]): List[A] = ls match {
    case Nil       => Nil
    case h :: tail => h :: compressRecursive(tail.dropWhile(_ == h))
  }

  // Tail recursive.
  def compressTailRecursive[A](ls: List[A]): List[A] = {
    def compressR(result: List[A], curList: List[A]): List[A] = curList match {
      case h :: tail => compressR(h :: result, tail.dropWhile(_ == h))
      case Nil       => result.reverse
    }
    compressR(Nil, ls)
  }

  // Functional.
  def compressFunctional[A](ls: List[A]): List[A] =
    ls.foldRight(List[A]()) { (h, r) =>
      if (r.isEmpty || r.head != h) h :: r
      else r
    }
  println(compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))

}
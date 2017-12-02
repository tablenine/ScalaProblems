package problem

object P5 extends App {
  def reverse[T](list: List[T]): List[T] = {
    def subReverse(retList: List[T], oriList: List[T]): List[T] = oriList match {
      case x :: xs => subReverse(x :: retList, xs)
      case _       => retList
    }

    if (!list.isEmpty) subReverse(List(), list)
    else Nil
  }

  val list = List(9, 8, 7, 6, 5, 4, 3, 2, 1)

  println(reverse(list))
}
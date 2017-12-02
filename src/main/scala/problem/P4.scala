package problem

object P4 extends App {
  def length[T](list: List[T]): Int = {
    def subLength(len: Int, subList: List[T]): Int = subList match {
      case Nil     => len
      case x :: xs => subLength(len + 1, xs)
    }

    subLength(0, list)
  }

  val list = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

  println(length(list))
  println(list.length)
}
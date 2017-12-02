package problem

object P6 extends App {
  def isPalindrome[T](list: List[T]): Boolean = list == list.reverse

  val list = List(1, 2, 3, 2, 1)
  println(isPalindrome(list))
}
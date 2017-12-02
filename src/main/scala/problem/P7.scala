package problem

object P7 extends App {
  def flatten(ls: List[Any]): List[Any] = ls flatMap {
    case ms: List[_] => flatten(ms)
    case e => List(e)
  }
  
  println(flatten(List(List(1, 1), 2, List(3, List(5, 8)))))
}
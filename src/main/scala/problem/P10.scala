package problem

object P10 extends App {
  def encode[A](ls: List[A]): List[(Int,A)] = {
    P9.pack(ls).map( e => (e.length, e.head))
  }
  
  val a = encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  println(a)
}
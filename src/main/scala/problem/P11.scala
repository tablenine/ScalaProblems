package problem

object P11 extends App {
  def encodeModified[A](ls: List[A]): List[Any] = {
    P9.pack(ls).map(e => (e.length, e.head)).map(t => if (t._1 == 1) t._2 else t)
  }

  def encodeModified2[A](ls: List[A]): List[Either[A, (Int, A)]] = {
    P9.pack(ls).map(e => (e.length, e.head)).map(t => if (t._1 == 1) Left(t._2) else Right(t))
  }

  val a = encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  val b = encodeModified2(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  println(a)
  val c = b.map(s => s match {
    case Left(l) => l
    case Right(r) => r
    case _ => "Error"
  })
  println(c)
}
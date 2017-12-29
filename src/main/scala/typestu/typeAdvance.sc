package typestu

object typeAdvance {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  implicit def strToInt(x: String) = { println("strToInt"); x.toInt }
                                                  //> strToInt: (x: String)Int

  val a = "123"                                   //> a  : String = 123
  val y: Int = "123"                              //> strToInt
                                                  //| y  : Int = 123
  class Container[A <% Int] { def addIt(x: A) = 123 + x }
  (new Container[String]).addIt("123")            //> strToInt
                                                  //| res0: Int = 246
  (new Container[Int]).addIt(123)                 //> res1: Int = 246
  //(new Container[Float]).addIt(123.2F)
  List(1, 2).sum                                  //> res2: Int = 3

  class Containers[A](value: A) { def addIt(implicit evidence: A =:= Int) = 123 + value }
  (new Containers(123)).addIt                     //> res3: Int = 246

  //class Containers2[A](value: A) { def addIt(implicit evidence: A <%< Int) = 123 + value }
  //(new Containers2("123")).addIt
  List(1, 2, 3, 4).min(new Ordering[Int] { def compare(a: Int, b: Int) = b compare a })
                                                  //> res4: Int = 4
  trait ContainerT[M[_]] { def put[A](x: A): M[A]; def get[A](m: M[A]): A }
  val container = new ContainerT[List] { def put[A](x: A) = List(x); def get[A](m: List[A]) = m.head }
                                                  //> container  : typestu.typeAdvance.ContainerT[List] = typestu.typeAdvance$$ano
                                                  //| n$2@3796751b
  container.put("hey")                            //> res5: List[String] = List(hey)
  container.put(123)                              //> res6: List[Int] = List(123)

  trait ContainerT2[M[_]] { def put[A](x: A): M[A]; def get[A](m: M[A]): A }
  implicit val listContainer = new ContainerT2[List] { def put[A](x: A) = List(x); def get[A](m: List[A]) = m.head }
                                                  //> listContainer  : typestu.typeAdvance.ContainerT2[List] = typestu.typeAdvanc
                                                  //| e$$anon$3@1e67b872
  implicit val optionContainer = new ContainerT2[Some] { def put[A](x: A) = Some(x); def get[A](m: Some[A]) = m.get }
                                                  //> optionContainer  : typestu.typeAdvance.ContainerT2[Some] = typestu.typeAdva
                                                  //| nce$$anon$4@60addb54
  def tupleize[M[_]: ContainerT2, A, B](fst: M[A], snd: M[B]) = {
    val c = implicitly[ContainerT2[M]]
    c.put(c.get(fst), c.get(snd))
  }                                               //> tupleize: [M[_], A, B](fst: M[A], snd: M[B])(implicit evidence$2: typestu.t
                                                  //| ypeAdvance.ContainerT2[M])M[(A, B)]
  tupleize(Some(1), Some(2))                      //> res7: Some[(Int, Int)] = Some((1,2))
  tupleize(List(1), List(2))                      //> res8: List[(Int, Int)] = List((1,2))
}
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
}
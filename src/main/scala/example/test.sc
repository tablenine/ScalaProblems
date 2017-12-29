package example

object test {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val f: PartialFunction[String, String] = { case "ping" => "pong" }
                                                  //> f  : PartialFunction[String,String] = <function1>
  f("ping")                                       //> res0: String = pong
  //f("abc")
  f.isDefinedAt("ping")                           //> res1: Boolean = true
  f.isDefinedAt("pong")                           //> res2: Boolean = false
  val s: String => String = { case "ping" => "pong" }
                                                  //> s  : String => String = example.test$$$Lambda$10/1277181601@27f674d
  List(1, 2, 3).zip(List("a", "b", "c", "D"))     //> res3: List[(Int, String)] = List((1,a), (2,b), (3,c))
  List(1, 2, 3, 4, 5).zip(List("a", "b", "c", "D"))
                                                  //> res4: List[(Int, String)] = List((1,a), (2,b), (3,c), (4,D))
  val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                                                  //> numbers  : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  numbers.foldLeft(0)((m: Int, n: Int) => m + n)  //> res5: Int = 55

  val nestedNumbers = List(List(1, 2), List(3, 4))//> nestedNumbers  : List[List[Int]] = List(List(1, 2), List(3, 4))
  nestedNumbers.flatMap(x => x.map(_ * 2))        //> res6: List[Int] = List(2, 4, 6, 8)
  nestedNumbers.map(x => x.map(_ * 2)).flatten    //> res7: List[Int] = List(2, 4, 6, 8)
  def timesTwo(i: Int): Int = i * 2               //> timesTwo: (i: Int)Int
  def ourMap(numbers: List[Int], fn: Int => Int): List[Int] = {
    numbers.foldRight(List[Int]()) { (x: Int, xs: List[Int]) => fn(x) :: xs
    }
  }                                               //> ourMap: (numbers: List[Int], fn: Int => Int)List[Int]
  ourMap(numbers, timesTwo(_))                    //> res8: List[Int] = List(2, 4, 6, 8, 10, 12, 14, 16, 18, 20)

  val extensions = Map("steve" -> 100, "bob" -> 101, "joe" -> 201)
                                                  //> extensions  : scala.collection.immutable.Map[String,Int] = Map(steve -> 100,
                                                  //|  bob -> 101, joe -> 201)
  extensions.filter((namePhone: (String, Int)) => namePhone._2 < 200)
                                                  //> res9: scala.collection.immutable.Map[String,Int] = Map(steve -> 100, bob -> 
                                                  //| 101)
  extensions.filter({ case (name, extension) => extension < 200 })
                                                  //> res10: scala.collection.immutable.Map[String,Int] = Map(steve -> 100, bob -
                                                  //| > 101)
  def addUmm(x: String): String = x + " umm"      //> addUmm: (x: String)String
  def addAhem(x: String): String = x + " ahem"    //> addAhem: (x: String)String
  
  val ummThenAhem = addAhem _ compose addUmm _    //> ummThenAhem  : String => String = scala.Function1$$Lambda$30/57494364@6d00a
                                                  //| 15d
  val ummThenAhem2 = (x: String) => addAhem(addUmm (x))
                                                  //> ummThenAhem2  : String => String = example.test$$$Lambda$31/1374677625@5034
                                                  //| c75a
  ummThenAhem("well")                             //> res11: String = well umm ahem
  ummThenAhem2("well")                            //> res12: String = well umm ahem
  
  val ummAndTheAhem = addAhem _ andThen addUmm _  //> ummAndTheAhem  : String => String = scala.Function1$$Lambda$34/2140832232@9
                                                  //| 629756
  ummAndTheAhem("well")                           //> res13: String = well ahem umm
  val one: PartialFunction[Int, String] = {case 1 => "one"}
                                                  //> one  : PartialFunction[Int,String] = <function1>
  one.isDefinedAt(1)                              //> res14: Boolean = true
  one.isDefinedAt(2)                              //> res15: Boolean = false
  val two: PartialFunction[Int, String] = {case 2 => "two"}
                                                  //> two  : PartialFunction[Int,String] = <function1>
  val three: PartialFunction[Int, String] = {case 3 => "three"}
                                                  //> three  : PartialFunction[Int,String] = <function1>
  val wildcard: PartialFunction[Int, String] = {case _ => "something else"}
                                                  //> wildcard  : PartialFunction[Int,String] = <function1>
  
  val partial = one orElse two orElse three orElse wildcard
                                                  //> partial  : PartialFunction[Int,String] = <function1>
  
  partial(5)                                      //> res16: String = something else
  partial(3)                                      //> res17: String = three
  partial(2)                                      //> res18: String = two
  partial(1)                                      //> res19: String = one
  partial(0)                                      //> res20: String = something else
  
  case class PhoneExt(name: String, ext: Int)
  
  val extensions2 = List(PhoneExt("steve", 100), PhoneExt("robey", 200))
                                                  //> extensions2  : List[example.test.PhoneExt] = List(PhoneExt(steve,100), Phon
                                                  //| eExt(robey,200))
  extensions2.filter {case PhoneExt(name, extension) => extension < 200}
                                                  //> res21: List[example.test.PhoneExt] = List(PhoneExt(steve,100))
}
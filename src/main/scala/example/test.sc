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
                                                  //> s  : String => String = example.test$$$Lambda$10/2088051243@4c203ea1
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
  
  val ummThenAhem = addAhem _ compose addUmm _    //> ummThenAhem  : String => String = scala.Function1$$Lambda$30/787867107@36d4
                                                  //| b5c
  val ummThenAhem2 = (x: String) => addAhem(addUmm (x))
                                                  //> ummThenAhem2  : String => String = example.test$$$Lambda$31/1828757853@51ef
                                                  //| ea79
  ummThenAhem("well")                             //> res11: String = well umm ahem
  ummThenAhem2("well")                            //> res12: String = well umm ahem
}
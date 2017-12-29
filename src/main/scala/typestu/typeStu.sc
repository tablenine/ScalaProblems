package typestu

object typeStu {
  class Animal { val sound = "rustle" }
  class Bird extends Animal { override val sound = "call" }
  class Chicken extends Bird {
    override val sound = "cluck"
    val ccc = "chicken"
  }
  println(1)                                      //> 1

  val getTweet: (Bird => String) = (a: Animal) => a.sound
                                                  //> getTweet  : typestu.typeStu.Bird => String = typestu.typeStu$$$Lambda$8/1577
                                                  //| 213552@3f0ee7cb
  getTweet(new Bird)                              //> res0: String = call
  
  def biophony[T <: Animal] (things: Seq[T]) = things.map(_.sound)
                                                  //> biophony: [T <: typestu.typeStu.Animal](things: Seq[T])Seq[String]
  biophony(Seq(new Chicken, new Bird))            //> res1: Seq[String] = List(cluck, call)
  val flock = List(new Bird, new Bird)            //> flock  : List[typestu.typeStu.Bird] = List(typestu.typeStu$Bird@5ebec15, typ
                                                  //| estu.typeStu$Bird@21bcffb5)
  new Chicken :: flock                            //> res2: List[typestu.typeStu.Bird] = List(typestu.typeStu$Chicken@380fb434, ty
                                                  //| pestu.typeStu$Bird@5ebec15, typestu.typeStu$Bird@21bcffb5)
  flock.::(new Chicken)                           //> res3: List[typestu.typeStu.Bird] = List(typestu.typeStu$Chicken@668bc3d5, ty
                                                  //| pestu.typeStu$Bird@5ebec15, typestu.typeStu$Bird@21bcffb5)
  flock :+ new Chicken                            //> res4: List[typestu.typeStu.Bird] = List(typestu.typeStu$Bird@5ebec15, typest
                                                  //| u.typeStu$Bird@21bcffb5, typestu.typeStu$Chicken@3cda1055)
	flock.+:(new Chicken)                     //> res5: List[typestu.typeStu.Bird] = List(typestu.typeStu$Chicken@7a5d012c, ty
                                                  //| pestu.typeStu$Bird@5ebec15, typestu.typeStu$Bird@21bcffb5)
  

}
package lectures.part3FunctionalProgramming

/* cliff created on 04/01/2021 inside the package - lectures.part3FunctionalProgramming */
object WhatsAFunction extends App {

def doubler = new MyFunction[Int, Int] {
  override def apply(element: Int): Int = element * 2
}

println(doubler(2))

  //Function types = Function[A, B]

  val stringToIntConvertor = new Function[String, Int] {
    override def apply(v1: String): Int = v1.toInt
  }

  println(stringToIntConvertor("3") + 4)

  val adder: (( Int, Int )  => Int ) = new Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }

  println(adder(1,2))

  //Function types Function2[A, B, R]  === (A, B) => R

  //REMEMBER ALL SCALA FUNCTIONS ARE OBJECTS

  /*
  1. take 2 strings and concatenate them
   */
  val string2Concatenate: ((String, String) => String) = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + v2
  }

  println(string2Concatenate("Cliff", "ord"))

  //higher order functions

  // Function1[Int, Function1[Int, Int]]

  val superAdder: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }
 //lambda version of the superAdder curried function
  val superAdder2 = (x: Int) => (y: Int) => x + y

 val adder3 = superAdder(3)
 println(adder3(4))
 println(superAdder(3)(4)) //curried function
  println(superAdder2(3)(4))

}

trait MyFunction[A, B] {
  def apply(element: A): B
}

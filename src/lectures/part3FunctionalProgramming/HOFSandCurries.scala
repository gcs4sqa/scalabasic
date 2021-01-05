package lectures.part3FunctionalProgramming

object HOFSandCurries extends App {


  def nTimes(f: Int => Int,n: Int, x: Int ): Int =
    if (n <= 0) x
    else nTimes(f, n-1, f(x))

  val onePlus = (x: Int) => x + 1

  println(onePlus(1))
  println(nTimes(onePlus, 10, 1))

  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) =
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n-1) (f(x))

  val plus10 = nTimesBetter(onePlus, 10)
  println(plus10(1))

  //functions with multiple parameters
  def curriedFunctions (c: String)(x: Double): String = c.format(x)

  val standardFormat: (Double=>String) = curriedFunctions("%4.2f")
  val precisionFormat: (Double=>String) =  curriedFunctions("%10.8f")

  println(standardFormat(Math.PI))
  println(precisionFormat(Math.PI))

  def toCurry(f: (Int, Int) => Int) : (Int => Int => Int) =
    x => y => f(x,y)

  def fromCurry(f: (Int => Int => Int)): (Int, Int) => Int =
    (x, y) => f(x)(y)

  def compose[A, B, T](f: A => B, g: T => A): T => B =
    x => f(g(x))

  def andThen[A, B, C](f: A => B, g: B => C): A => C =
    x => g(f(x))

  def superAdder2:(Int => Int => Int) = toCurry(_+_)
  def add4 = superAdder2(4)
  println(add4(17))

  val superAdder: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  val simpleAdder = fromCurry(superAdder)
  println(simpleAdder(4,17))

  val add2 = (x: Int) => x + 2
  val times3 = (x: Int) => x * 3

  val composed = compose(add2, times3)
  val ordered = andThen(add2, times3)

  println(composed(4))
  println(ordered(4))


}

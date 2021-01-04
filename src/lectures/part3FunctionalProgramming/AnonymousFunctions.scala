package lectures.part3FunctionalProgramming

/* cliff created on 04/01/2021 inside the package - lectures.part3FunctionalProgramming */
object AnonymousFunctions extends App{

  //anonymous function (LAMBDA)
  val doubler = (x: Int) => x * 2
  //or
  val doubler2: Int => Int = x => x * 2

  //multiple params for LAMBDA must be in paras
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  //no params
  val justDoSomething: () => Int = () => 3

  println(doubler(12))
  println(doubler2(12))
  println(adder(3, 4))
  //LAMBDA must be called with parenthesis
  println(justDoSomething())

  //curly braces with LAMBDAs
  val stringToInt = { (str: String) =>
    str.toInt
  }
  println(stringToInt("123"))

  //More syntactic sugar
  val niceIncrementor: Int => Int = _ + 1 //equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _ //equivalent to (a, b) => a + b

  //lambda version of the superAdder curried function
  val superAdder2 = (x: Int) => (y: Int) => x + y

}

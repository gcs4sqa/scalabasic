package lectures.part2oop

object Exceptions extends App {

  val x : String = null

  //println(x.length)

  //1. Throwing and catching exceptions
  //val aWierdValue = throw new NullPointerException

  //throwable classes extend the throwable class
  //Exception and Error are the major throwable subtypes

  //2. how to catch exceptions
  def getInt(withException: Boolean): Int = {
    if (withException) throw new RuntimeException("no int for you!")
    else 42
  }

  try {
    //code that would throw an exception
    getInt(true)
  } catch {
    case e: RuntimeException => println("Caught a RuntimeException")
  } finally {
    //code that would get executed NO MATTER WHAT
    //optional
    //does not influence return type
    println("finally")
  }

  //3. how to derive your own exception
  class MyException extends Exception {
    val exception = new MyException

    throw exception
  }
 // OOM
  //val array = Array.ofDim(Int.MaxValue)

  //  SO
  //def infinite: Int = 1 + infinite
  //val noLimit = infinite

  class OverFlowException extends RuntimeException
  class UnderFlowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Division by Zero")

  object PocketCalculator{
    def add(x:Int, y:Int) = {
      val result = x + y
      if ( x > 0 && y > 0 && result < 0) throw new OverFlowException
      else if (x < 0 && y < 0 && result >0 ) throw new UnderFlowException
      else result
    }
    def subtract(x:Int, y: Int) = {
      val result = x - y
      if (x > 0 && y < 0 && result < 0 ) throw new OverFlowException
      else if ( x < 0 && y > 0 && result > 0 ) throw new UnderFlowException
      else result
    }

    def multiple(x: Int, y: Int) = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverFlowException
      else if (x < 0 && y < 0 && result < 0) throw new OverFlowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderFlowException
      else if (x < 0 && y >0 && result > 0) throw new UnderFlowException
      else result
    }

    def divide(x : Int, y : Int) = {
      if (y == 0)  throw new MathCalculationException
      else x / y

    }
  }

  //println(PocketCalculator.add(Int.MaxValue, 10))
  println(PocketCalculator.divide(2, 0))

}

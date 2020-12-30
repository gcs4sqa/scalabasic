package lectures.part1basics


import scala.annotation.tailrec

object Recursion extends App {

  //just experimenting with booleans
  //println(7 % 3 != 0 && true)

def factorial(n: Int): Int = {
  if (n <= 1)1
  else {
    println("computing the factorial of " + n + " - first I need the factorial of " + (n-1) )
    val result = n * factorial(n-1)
    println("computed the factorial of " + n)
    result
  }
}

  println(factorial(10))
  //println(factorial(5000))

  def anotherFactorial(n: Int):BigInt = {
    @tailrec
    def factHelper(x:Int, accumlator: BigInt):BigInt =
      if(x <= 1) accumlator
      else factHelper(x - 1, x * accumlator)

    factHelper(n, 1)
  }

  println(anotherFactorial(10))
  println(anotherFactorial(5000))

  //exercise
  //1. concatenate a string n times


  //println(aRepeatedFunction("Cliff", 50000))

  def recursiveString(aString: String, n:Int):String = {
    @tailrec
    def helperString(x:Int, accumlator:String ):String =
      if (x <= 1) accumlator
      else helperString(x - 1, aString + accumlator)

    helperString(n -1 , aString )
  }

  @tailrec
  def concatenateTailRec(aString: String, n:Int, accumulator: String):String={
    if (n <= 0 ) accumulator
    else concatenateTailRec(aString, n-1, aString + accumulator)
  }

  println(concatenateTailRec("douglas", 33, ""))

  println(recursiveString("cliff", 50))

  //2. isPrime function tail recursion

  def isPrime(n: Int):Boolean = {
    @tailrec
    def isPrimeUntil(t: Int): Boolean =
      if(t <= 1) true
      else n % t != 0 && isPrimeUntil(t-1)
    isPrimeUntil(n/2)

  }

  def isPrime1(n: Int):Boolean = {
    @tailrec
    def isPrime1TailRec(t:Int, isStillPrime:Boolean):Boolean=
      if (!isStillPrime)false
      else if (t <= 1) true
      else isPrime1TailRec(t - 1, n % t != 0 && isStillPrime)

    isPrime1TailRec(n / 2, true)
  }

  println(isPrime(6))

  println(isPrime1(4))

  //3. Fibonacci number tail recursion

  def fibonacci(n:Int): Int = {
    @tailrec
    def fibTailRec(i : Int, last : Int, nextLast: Int): Int =
      if (i >= n)last
      else fibTailRec(i+1, last + nextLast, last)
    if (n <= 2)1
    else fibTailRec(2, 1, 1)
  }

  println(fibonacci(8))

}

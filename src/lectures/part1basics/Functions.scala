package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int): String =
    a + " " + b


  println(aFunction("hello", 3))

  //parameterless function
  def aParameterlessFunction(): Int = 42

  println(aParameterlessFunction())
  println(aParameterlessFunction)

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }

  println(aRepeatedFunction("Cliff", 20))

  //when you need loops use recursion

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  aFunctionWithSideEffects("test")


  //exercises
  //1.
  def Greeting(name: String, age: Int): String =
    "Hi, my name is " + name + " and I am " + age + " years old"

  println(Greeting("Cliff", 57))

  //2.
  def factorialFunction(n:Int):Int = {
    if(n <= 0)1 else
      n * factorialFunction(n-1)
  }

  println(factorialFunction(5))

  //3. a fabonacci number
  def fibonacciFunction(n:Int):Int = {
    if(n <= 2)1
    else fibonacciFunction(n-1) + fibonacciFunction(n - 2)
  }

  println("fibonacci: " + fibonacciFunction(3))



  //4. is a number a prime
  def isAPrime(n:Int):String = {
    val result:Float = n % 2
    if(result > 0 || n == 2)n + " is a prime number"
    else n + " is not a prime number"
  }

  def isPrime(n: Int):Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if(t <= 1) true
      else n % t != 0 && isPrimeUntil(t-1)
      isPrimeUntil(n/2)

  }

  println(isAPrime(5))
  println(isAPrime(37*17))
  println(isPrime(37*17))


}








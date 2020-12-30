package lectures.part1basics

object ValuesVariablesTypes extends App {
  val x:Int = 42
  print(x)

  val aString: String = "Hello"
  val anotherString = "goodbye"

  val aBoolean: Boolean = true
  val anotherBoolean = false
  val aChar: Char ='a'
  val aShort: Short = 12344
  val aLong: Long = 123456789123L
  val aFloat: Float = 1.23f
  val anotherFloat = 1.23f
  val aDouble: Double = 1.23

  //variable

  var aVariable: Int = 2
  aVariable = 5 //side effects
}

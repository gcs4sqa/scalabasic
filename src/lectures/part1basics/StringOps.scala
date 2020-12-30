package lectures.part1basics

object StringOps extends App {

  val str: String = "Hello, I am learning Scala"

  println(str.charAt(2))
  println(str.substring(7, 11))
  println(str.split(" ").toList)
  println(str.startsWith("Hello")) //returns true
  println(str.startsWith("today")) //returns false
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.toUpperCase())
  println(str.length)

  val aStringNumber: String = "45"
  val aIntnumber: Int = aStringNumber.toInt
  println('a' +: aStringNumber :+'z')
  println(str.reverse)
  println(str.take(2))

  //string interpolators

  //s-interpolators
  val name = "Cliff"
  val age = 57
  val greeting = s"Hello my name is $name and my age is $age"
  val anotherGreeting = s"Hello my name is $name and I will be ${age + 1} at my next birthday"
  println(greeting)
  println(anotherGreeting)

  //f-interpolators
  val speed = 1.2f
  val myth = f"$name%s can eat $speed%2.2f burgers per hour"
  println(myth)

  //raw-interpolator
  println("this is a line \n with a line break")
  println(raw"this is a line \n with a line break")
}

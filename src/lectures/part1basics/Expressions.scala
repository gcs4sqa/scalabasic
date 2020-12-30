package lectures.part1basics

object Expressions extends App {
  val x = 1 + 2 //1 + 2 is an expression
  println(x)

  println(1 + 2 * 4)

  println(1 == x)

  println(!(1 == x))

  var aVarible = 2
  aVarible += 3
  println(aVarible)

  //Instructions (Do) v Expressions (Value)
  // (java is an imperative language - ie changes the programmes state.

  //if expression
  val aCondition = false
  val aConditionValue = if (aCondition) 5 else 3
  println(aConditionValue)

  //loops are available in scala but are discouraged

  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }

  //NEVER WRITE LOOPS

  val aWeirdValue = (aVarible = 3) //this returns a Unit == void
  println(aWeirdValue)

  //code blocks

  val aCodeBlock = {
    val y = 2
    val z = x + 1

    if (y > 2) "hello" else "goodbye"
  }




}
